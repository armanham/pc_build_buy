package team.foura.backend.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import team.foura.backend.model.dto.AdminDTO;

import static team.foura.pattern.Pattern.*;

/**
 * Represents a request for creating or updating an admin user.
 *
 * <p>The {@code AdminCreationRequest} record encapsulates the data required to create or update an admin user.
 * It contains properties such as username, password, email, and phone, which are validated using
 * various regular expression patterns and constraints.
 *
 * @author Ani Hakobyan
 */
public record AdminCreationRequest(
        @Pattern(
                regexp = ADMIN_USERNAME_PATTERN,
                message = WRONG_ADMIN_USERNAME_MESSAGE
        )
        @JsonProperty("username")
        String username,

//        @Pattern(
//                regexp = PASSWORD_PATTERN,
//                message = WRONG_PASSWORD_MESSAGE
//        )
        @JsonProperty("password")
        String password,

        @NotBlank(message = "email must be provided: ")
        @Pattern(
                regexp = EMAIL_PATTERN,
                message = WRONG_EMAIL_MESSAGE
        )
        @JsonProperty("email")
        String email,

        @Pattern(
                regexp = PHONE_PATTERN,
                message = WRONG_PHONE_MESSAGE
        )
        @JsonProperty("phone")
        String phone
) {
}