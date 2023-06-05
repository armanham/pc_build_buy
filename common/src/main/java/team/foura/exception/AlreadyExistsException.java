package team.foura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an entity already exists.
 *
 * <p>The {@code AlreadyExistsException} is a runtime exception that is thrown when an attempt
 * is made to create or update an entity that already exists in the system. It is typically used
 * to indicate a violation of uniqueness constraints, such as when trying to create a new entity
 * with a property value that already exists in the database.
 *
 * <p>The exception message provides information about the entity class, the property name, and
 * the property value that caused the conflict. It can be retrieved using the {@link #getMessage()}
 * method.
 *
 * <p>By extending the {@link RuntimeException} class, this exception is an unchecked exception
 * that does not require explicit handling, providing convenience in error handling and propagation.
 *
 * @author Arman Hambardzumyan
 */

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(Class entity, String propertyName, String propertyValue) {
        super(entity.getSimpleName() + " with " + propertyName + ": " + propertyValue + " already exists: ");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}