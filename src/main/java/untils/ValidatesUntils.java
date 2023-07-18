package untils;

import java.util.regex.Pattern;

public class ValidatesUntils {
    public static final String USERNAME_REGEX = "^[A-Za-z]+[ ]+[A-Za-z]{3,20}$";
    public static final String DESCRIPTION_REGEX = "^[A-Za-z]+[ ]+[A-Za-z]{3,49}$";
    private static final String CREATEAT_REGEX = "^[0-9]{1,2}+[-]+[0-9]{1,2}+[-][0-9]{4}$";

    public static boolean isUserNameValid(String name) {
        return Pattern.matches(USERNAME_REGEX, name);
    }

    public static boolean isValidDescription(String email) {
        return Pattern.matches(DESCRIPTION_REGEX, email);
    }
    public static boolean isValidCreateAT(String createAt) {
        return Pattern.matches(CREATEAT_REGEX, createAt);
    }
}
