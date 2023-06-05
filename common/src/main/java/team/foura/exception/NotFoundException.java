package team.foura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an entity is not found.
 *
 * <p>The {@code NotFoundException} is a runtime exception that is thrown when an entity is not
 * found in the system. It is typically used to indicate that a requested entity or resource could
 * not be located or does not exist.
 *
 * <p>The exception message provides information about the entity class and the specific identifier
 * or property value that was used to search for the entity. It can be retrieved using the
 * {@link #getMessage()} method.
 *
 * <p>By extending the {@link RuntimeException} class, this exception is an unchecked exception
 * that does not require explicit handling, providing convenience in error handling and propagation.
 *
 * @author Arman Hambardzumyan
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(Class entity, Number id) {
        super(entity.getSimpleName() + " with id: " + id + " not found: ");
    }

    public NotFoundException(Class entity, String propertyName, String propertyValue) {
        super(entity.getSimpleName() + " with " + propertyName + ": " + propertyValue + " not found: ");
    }

    public NotFoundException(Class entity, String username) {
        super(entity.getSimpleName() + " with username: " + username + " not found: ");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}