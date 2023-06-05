package team.foura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an entity is not active.
 *
 * <p>The {@code IsNotActiveException} is a runtime exception that is thrown when an operation
 * is performed on an entity that is not in an active state. It is typically used to indicate that
 * the requested action cannot be performed on an inactive entity.
 *
 * <p>The exception message provides information about the entity class, the property name, and
 * the property value that is not active. It can be retrieved using the {@link #getMessage()} method.
 *
 * <p>By extending the {@link RuntimeException} class, this exception is an unchecked exception
 * that does not require explicit handling, providing convenience in error handling and propagation.
 *
 * @author Arman Hambardzumyan
 */

@ResponseStatus(value = HttpStatus.LOCKED)
public class IsNotActiveException extends RuntimeException {

    public IsNotActiveException(Class entity, String propertyName, String propertyValue) {
        super(entity.getSimpleName() + " with " + propertyName + ": " + propertyValue + " is not active: ");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
