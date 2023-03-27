package ru.job4j.early;

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

    private static boolean lengthBetween(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD && password.length() <= MAX_LENGTH_PASSWORD;
    }

    private static boolean allChecksIsCondition(SymbolInGroup[] checks) {
        for (SymbolInGroup check : checks) {
            if (!check.isFound()) {
                return false;
            }
        }
        return true;
    }

    private static void throwFirstException(SymbolInGroup[] checks) {
        for (SymbolInGroup check : checks) {
            if (!check.isFound()) {
                check.throwException();
            }
        }
    }

    private static void existsMatchForAllGroups(String password) {
        char[] chars = password.toCharArray();
        SymbolInGroup[] checks = {
                new IsUpperCase(),
                new IsLowerCase(),
                new IsDigit(),
                new IsNotLetterOrDigit()
        };
        for (char aChar : chars) {
            for (SymbolInGroup check : checks) {
                check.isSymbolInGroup(aChar);
            }
            if (allChecksIsCondition(checks)) {
                return;
            }
        }
        throwFirstException(checks);
    }

    private static boolean existsSpecialSubstring(String password) {
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
        if (existsSpecialSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: " + String.join(", ", BAD_SUBSTRINGS));
        }
        return password;
    }
}
