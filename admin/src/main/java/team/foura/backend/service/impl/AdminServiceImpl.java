package team.foura.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.foura.backend.model.dto.AdminDTO;
import team.foura.backend.model.entity.Admin;
import team.foura.backend.model.enums.Status;
import team.foura.backend.repository.AdminRepository;
import team.foura.backend.service.AdminService;
import team.foura.exception.AlreadyExistsException;
import team.foura.exception.IsNotActiveException;
import team.foura.exception.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Implementation of the {@link AdminService} interface for managing admin users.
 *
 * <p>The {@code AdminServiceImpl} class provides the actual implementation of the methods
 * defined in the {@link AdminService} interface. It encapsulates the business logic for managing
 * admin users and interacts with the {@link AdminRepository} to perform data access operations.
 *
 * <p>As a {@code @Service} component, this class is responsible for handling admin user management
 * operations and coordinating with other components of the application to fulfill the desired
 * functionality.
 *
 * <p>By separating the service implementation from the interface, it allows for modularity and
 * easier maintenance of the codebase. The implementation can evolve independently from the interface,
 * providing flexibility and extensibility.
 *
 * @author Ani Hakobyan, Arman Hambardzumyan
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean save(final AdminDTO dto) {
        if (adminRepository.findByUsername(dto.username()).isPresent()) {
            throw new AlreadyExistsException(Admin.class, "username", dto.username());
        }
        if (adminRepository.findByPhone(dto.phone()).isPresent()) {
            throw new AlreadyExistsException(Admin.class, "phone", dto.phone());
        }
        if (adminRepository.findByEmail(dto.email()).isPresent()) {
            throw new AlreadyExistsException(Admin.class, "email", dto.email());
        }
        adminRepository.save(new Admin(dto));
        return true;
    }

    @Override
    public void deactivate(final String username) {
        getAdmin(username).setStatus(Status.valueOf("INACTIVE"));
    }

    @Override
    public String updateUsername(final String username, final String newUsername) {
        Admin admin = getAdmin(username);
        if (adminRepository.findByUsername(newUsername).isPresent()) {
            throw new AlreadyExistsException(Admin.class, "username", newUsername);
        }
        admin.setUsername(newUsername);
        return newUsername;
    }

    @Override
    public String updatePhone(String username, String newPhone) {
        Admin admin = getAdmin(username);
        if (adminRepository.findByPhone(newPhone).isPresent()) {
            throw new AlreadyExistsException(Admin.class, "phone", newPhone);
        }
        admin.setPhone(newPhone);
        return newPhone;
    }

    @Override
    public String updateEmail(String username, String newEmail) {
        Admin admin = getAdmin(username);
        if (adminRepository.findByEmail(newEmail).isPresent()) {
            throw new AlreadyExistsException(Admin.class, "email", newEmail);
        }
        admin.setEmail(newEmail);
        return newEmail;
    }

    @Override
    public boolean updatePasswordByUsername(String username, String newPassword) {
        return false;
    }

    @Override
    public boolean updatePasswordByPhone(String phone, String newPassword) {
        return false;
    }

    @Override
    public boolean updatePasswordByEmail(String email, String newPassword) {
        return false;
    }

    @Override
    public List<AdminDTO> findAllActiveAdmins() {
        return adminRepository.findAll()
                .stream()
                .filter(admin -> admin.getStatus().toString().equals("ACTIVE"))
                .map(AdminDTO::initDTOFromEntity)
                .toList();
    }

    @Override
    public List<AdminDTO> findAllInactiveAdmins() {
        return adminRepository.findAll()
                .stream()
                .filter(admin -> admin.getStatus().toString().equals("INACTIVE"))
                .map(AdminDTO::initDTOFromEntity)
                .toList();
    }

    @Override
    public List<AdminDTO> findAll() {
        return Stream.concat(findAllActiveAdmins().stream(), findAllInactiveAdmins().stream()).toList();
//        return adminRepository.findAll()
//                .stream()
//                .map(AdminDTO::initDTOfromEntity)
//                .toList();
    }


    /**
     * Retrieves an active admin user by their username.
     *
     * @param username the username of the admin user to retrieve
     * @return the active admin user with the specified username
     * @throws team.foura.exception.NotFoundException    if no admin user with the given username is found
     * @throws team.foura.exception.IsNotActiveException if the admin user is inactive
     */
    private Admin getAdmin(String username) {
        Optional<Admin> optionalAdmin = adminRepository.findByUsername(username);
        if (optionalAdmin.isEmpty()) {
            throw new NotFoundException(Admin.class, "username", username);
        }
        if (optionalAdmin.get().toString().equals("INACTIVE")) {
            throw new IsNotActiveException(Admin.class, "username", username);
        }
        return optionalAdmin.get();
    }
}