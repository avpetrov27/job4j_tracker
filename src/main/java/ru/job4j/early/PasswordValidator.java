package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 32;
    private static final String[] SPECIAL_SUBSTRINGS = {
            "qwerty",
            "12345",
            "password",
            "admin",
            "user"};

    private static boolean lengthBetween(String password) {
        return password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH;
    }

    private static boolean existsUpperCaseLetter(String password) {
        char[] chars = password.toCharArray();
        for (char aChar : chars) {
            if (isUpperCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existsLowerCaseLetter(String password) {
        char[] chars = password.toCharArray();
        for (char aChar : chars) {
            if (isLowerCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existsDigit(String password) {
        char[] chars = password.toCharArray();
        for (char aChar : chars) {
            if (isDigit(aChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existsSpecialSymbol(String password) {
        char[] chars = password.toCharArray();
        for (char aChar : chars) {
            if (!isLetterOrDigit(aChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existsSpecialSubstring(String password) {
        for (String specialSubstring : SPECIAL_SUBSTRINGS) {
            if (password.toUpperCase().contains(specialSubstring.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (!lengthBetween(password)) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!existsUpperCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!existsLowerCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!existsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!existsSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (existsSpecialSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
