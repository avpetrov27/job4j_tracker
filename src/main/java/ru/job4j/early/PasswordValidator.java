package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 32;
    private static final String[] BAD_SUBSTRINGS = {
            "qwerty",
            "12345",
            "password",
            "admin",
            "user"
    };

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(
                    "Password can't be null");
        }
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "Password should be length [" + MIN_LENGTH + ", " + MAX_LENGTH + "]");
        }
        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigital = false;
        boolean hasSpecial = false;
        for (char aChar : password.toCharArray()) {
            if (!hasUpCase) {
                hasUpCase = isUpperCase(aChar);
            }
            if (!hasLowCase) {
                hasLowCase = isLowerCase(aChar);
            }
            if (!hasDigital) {
                hasDigital = isDigit(aChar);
            }
            if (!hasSpecial) {
                hasSpecial = !isLetterOrDigit(aChar);
            }
            if (hasUpCase && hasLowCase && hasDigital && hasSpecial) {
                break;
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (!hasDigital) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol");
        }
        for (String badSubstring : BAD_SUBSTRINGS) {
            if (password.toUpperCase().contains(badSubstring.toUpperCase())) {
                throw new IllegalArgumentException(
                        "Password shouldn't contain substrings: "
                                + String.join(", ", BAD_SUBSTRINGS));
            }
        }
        return password;
    }
}
