package team.foura.backend.model.dto;

import team.foura.backend.model.entity.Admin;
import team.foura.backend.model.request.AdminCreationRequest;

import java.util.Objects;

/**
 * Represents a Data Transfer Object (DTO) for an admin user.
 *
 * <p>The {@code AdminDTO} record encapsulates the information of an admin user, including the
 * username, password, email, phone, and status. It provides a convenient way to transfer data
 * between different layers of the application.
 *
 * @author Arman Hambardzumyan
 */
public record AdminDTO(
        String username,
        String password,
        String email,
        String phone,
        String status) {

    /**
     * Initializes an AdminDTO object based on the provided Admin entity.
     *
     * @param admin the Admin entity from which to initialize the AdminDTO
     * @return an initialized AdminDTO object
     */
    public static AdminDTO initDTOFromEntity(final Admin admin){
        return new AdminDTO(admin.getUsername(), admin.getPassword(), admin.getEmail(), admin.getPhone(), String.valueOf(admin.getStatus()));
    }


    /**
     * Initializes an AdminDTO object based on the provided Admin creation request.
     *
     * @param creationRequest the Admin creation request from which to initialize the AdminDTO
     * @return an initialized AdminDTO object
     */
    public static AdminDTO initDTOFromRequest(final AdminCreationRequest creationRequest){
        return new AdminDTO(creationRequest.username(), creationRequest.password(), creationRequest.email(), creationRequest.phone(), "ACTIVE");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDTO = (AdminDTO) o;
        return Objects.equals(username, adminDTO.username)
                && Objects.equals(password, adminDTO.password)
                && Objects.equals(email, adminDTO.email)
                && Objects.equals(phone, adminDTO.phone)
                && status == adminDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email, phone, status);
    }
}