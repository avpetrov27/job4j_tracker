package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static final int MIN_LENGTH_PASSWORD = 8;
    private static final int MAX_LENGTH_PASSWORD = 32;
    private static final String[] BAD_SUBSTRINGS = {
            "qwerty",
            "12345",
            "password",
            "admin",
            "user"
    };

    private static final String[] SYMBOL_CHECKS_AND_E_MESSAGE = {
            "Password should contain at least one uppercase letter",
            "Password should contain at least one lowercase letter",
            "Password should contain at least one figure",
            "Password should contain at least one special symbol"
    };

    private static boolean isSymbolInGroup(char symbol, int type) {
        return switch (type) {
            case 0 -> isUpperCase(symbol);
            case 1 -> isLowerCase(symbol);
            case 2 -> isDigit(symbol);
            case 3 -> !isLetterOrDigit(symbol);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    private static boolean allChecksIsTrue(boolean[] checks) {
        for (boolean check : checks) {
            if (!check) {
                return false;
            }
        }
        return true;
    }

    private static void throwFirstException(boolean[] checks) {
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i]) {
                throw new IllegalArgumentException(SYMBOL_CHECKS_AND_E_MESSAGE[i]);
            }
        }
    }

    private static void existsMatchForAllGroups(String password) {
        char[] chars = password.toCharArray();
        boolean[] checks = new boolean[SYMBOL_CHECKS_AND_E_MESSAGE.length];
        for (char aChar : chars) {
            for (int i = 0; i < checks.length; i++) {
                if (!checks[i]) {
                    checks[i] = isSymbolInGroup(aChar, i);
                }
            }
            if (allChecksIsTrue(checks)) {
                return;
            }
        }
        throwFirstException(checks);
    }

    private static boolean lengthBetween(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD && password.length() <= MAX_LENGTH_PASSWORD;
    }

    private static boolean existsBadSubstring(String password) {
        for (String badSubstring : BAD_SUBSTRINGS) {
            if (password.toUpperCase().contains(badSubstring.toUpperCase())) {
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
            throw new IllegalArgumentException("Password should be length [" + MIN_LENGTH_PASSWORD + ", " + MAX_LENGTH_PASSWORD + "]");
        }
        existsMatchForAllGroups(password);
        if (existsBadSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: " + String.join(", ", BAD_SUBSTRINGS));
        }
        return password;
    }
}
