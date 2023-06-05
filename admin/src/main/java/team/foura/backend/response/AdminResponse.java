package team.foura.backend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import team.foura.backend.model.dto.AdminDTO;

/**
 * Represents a response containing admin user information.
 *
 * <p>The {@code AdminResponse} record encapsulates the information of an admin user
 * that is sent as a response from the application. It includes properties such as username,
 * email, phone, and status.
 *
 * <p>The record provides a static factory method {@code initResponseFromDTO} that allows
 * creating an {@code AdminResponse} object from an {@link AdminDTO} object.
 *
 * <p>This record is typically used to send admin user information to clients or other parts
 * of the application in a structured format.
 *
 * @author Arman Hambardzumyan
 */
public record AdminResponse(
        @JsonProperty(value = "username")
        String username,

        @JsonProperty(value = "email")
        String email,

        @JsonProperty(value = "phone")
        String phone,

        @JsonProperty(value = "status")
        String status
) {
    /**
     * Creates an {@code AdminResponse} object based on the provided {@link AdminDTO}.
     *
     * @param dto the {@link AdminDTO} object containing the admin user information
     * @return an {@code AdminResponse} object initialized with the data from the {@link AdminDTO}
     */
    public static AdminResponse initResponseFromDTO(final AdminDTO dto){
        return new AdminResponse(dto.username(), dto.email(), dto.phone(), dto.status());
    }
}