package team.foura.backend.service;

import team.foura.backend.model.dto.AdminDTO;

import java.util.List;

/**
 * Service interface for managing admin users.
 *
 * <p>The {@code AdminService} interface defines methods for managing and performing operations
 * related to admin users. It acts as an abstraction layer between the application's business logic
 * and the underlying data access layer.
 *
 * <p>Implementing classes are responsible for providing the necessary functionality to create,
 * retrieve, update, and delete admin users, as well as perform other operations specific to admin
 * user management.
 *
 * <p>By defining the operations in this interface, it allows for better separation of concerns and
 * facilitates modularity and testability of the admin user management functionality.
 *
 * @author Ani Hakobyan, Arman Hambardzumyan
 */
public interface AdminService {

    /**
     * Saves a new admin user based on the provided AdminDTO.
     *
     * @param dto the AdminDTO object containing the details of the admin user to save
     * @return true if the admin user was successfully saved
     * @throws team.foura.exception.AlreadyExistsException if an admin user with the same username, phone, or email already exists
     */
    boolean save(final AdminDTO dto);


    /**
     * Deactivates an admin user with the specified username.
     *
     * @param username the username of the admin user to deactivate
     * @throws team.foura.exception.NotFoundException    if no admin user with the given username is found
     * @throws team.foura.exception.IsNotActiveException if the admin user is already inactive
     */
    void deactivate(final String username);


    /**
     * Updates the username of an active admin user.
     *
     * @param username    the current username of the admin user
     * @param newUsername the new username to be set
     * @return the updated username if the update was successful
     * @throws team.foura.exception.NotFoundException      if no admin user with the given current username is found
     * @throws team.foura.exception.IsNotActiveException   if the admin user is inactive
     * @throws team.foura.exception.AlreadyExistsException if an admin user with the new username already exists
     */
    String updateUsername(final String username, final String newUsername);


    /**
     * Updates the phone number of an active admin user and returns the new phone number.
     *
     * @param username the username of the admin user
     * @param newPhone the new phone number to be set
     * @return the updated phone number if the update was successful
     * @throws team.foura.exception.NotFoundException if no admin user with the given username is found
     * @throws team.foura.exception.NotFoundException if the admin user is inactive
     * @throws team.foura.exception.NotFoundException if an admin user with the new phone number already exist
     */
    String updatePhone(String username, String newPhone);


    /**
     * Updates the email of an active admin user and returns the new email.
     *
     * @param username the username of the admin user
     * @param newEmail the new email to be set
     * @return the updated email if the update was successful
     * @throws team.foura.exception.NotFoundException if no admin user with the given username is found
     * @throws team.foura.exception.NotFoundException if the admin user is inactive
     * @throws team.foura.exception.NotFoundException if an admin user with the new email already exists
     */
    String updateEmail(String username, String newEmail);

    //entaka e popxman
    boolean updatePasswordByUsername(String username, String newPassword);

    boolean updatePasswordByPhone(String phone, String newPassword);

    boolean updatePasswordByEmail(String email, String newPassword);


    /**
     * Retrieves a list of all active admin users and returns them as a list of AdminDTO objects.
     *
     * @return an unmodifiable list of AdminDTO objects representing all active admin users
     */
    List<AdminDTO> findAllActiveAdmins();


    /**
     * Retrieves a list of all inactive admin users and returns them as a list of AdminDTO objects.
     *
     * @return an unmodifiable list of AdminDTO objects representing all inactive admin users
     */
    List<AdminDTO> findAllInactiveAdmins();


    /**
     * Retrieves a list of all admin users and returns them as a list of AdminDTO objects.
     *
     * @return an unmodifiable list of AdminDTO objects representing all admin users
     */
    List<AdminDTO> findAll();
}