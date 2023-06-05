package team.foura.pattern;

/**
 * Utility class that defines patterns and error messages for validation
 *
 * @author Ani Hakobyan, Arman Hambardzumyan
 */
public class Pattern {

    public static final String PHONE_PATTERN = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static final String ADMIN_USERNAME_PATTERN = "^[a-z]{3,10}$";

    public static final String USER_USERNAME_PATTERN = "^[a-z][a-z0-9_]{5,15}$";


    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=]).{8,15}$\n";


    public static final String WRONG_PHONE_MESSAGE = "The phone number must be like these: \n" +
            "123-456-7890\n" +
            "(123) 456-7890\n" +
            "123 456 7890\n" +
            "123.456.7890\n" +
            "+91 (123) 456-7890";


    public static final String WRONG_EMAIL_MESSAGE = "Email address must be like this: email@example.com";

    public static final String WRONG_ADMIN_USERNAME_MESSAGE = "Username must satisfy these requirements: \n" +
            "starts with lowercase \n" +
            "length must be from 3 to 10 characters(inclusive)";

    public static final String WRONG_USER_USERNAME_MESSAGE = "Username must satisfy these requirements: \n" +
            "starts with lowercase \n" +
            "may contain lowercase, digits or _ \n" +
            "length must be from 5 to 15 characters(inclusive)";


    public static final String WRONG_PASSWORD_MESSAGE = "Password must satisfy these requirements: .\n" +
            "at least one uppercase letter.\n" +
            "at least one digit.\n" +
            "at least one special character from the set: !@#$%^&*()_-+=\n" +
            "length from 8 to 15 characters(inclusive).";
}