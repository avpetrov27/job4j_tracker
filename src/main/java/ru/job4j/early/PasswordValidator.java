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

    private enum SymbolChecks {
        IS_UPPER_CASE {
            private boolean found = false;

            @Override
            public void checking(char symbol) {
                if (isUpperCase(symbol)) {
                    found = true;
                }
            }

            @Override
            public boolean isFound() {
                return found;
            }

            @Override
            public void throwException() {
                throw new IllegalArgumentException("Password should contain at least one uppercase letter");
            }

            @Override
            public void reset() {
                found = false;
            }
        },
        IS_LOWER_CASE {
            private boolean found = false;

            @Override
            public void checking(char symbol) {
                if (isLowerCase(symbol)) {
                    found = true;
                }
            }

            @Override
            public boolean isFound() {
                return found;
            }

            @Override
            public void throwException() {
                throw new IllegalArgumentException("Password should contain at least one lowercase letter");
            }

            @Override
            public void reset() {
                found = false;
            }
        },
        IS_DIGIT {
            private boolean found = false;

            @Override
            public void checking(char symbol) {
                if (isDigit(symbol)) {
                    found = true;
                }
            }

            @Override
            public boolean isFound() {
                return found;
            }

            @Override
            public void throwException() {
                throw new IllegalArgumentException("Password should contain at least one figure");
            }

            @Override
            public void reset() {
                found = false;
            }
        },
        IS_NOT_LETTER_OR_DIGIT {
            public boolean found = false;

            @Override
            public void checking(char symbol) {
                if (!isLetterOrDigit(symbol)) {
                    found = true;
                }
            }

            @Override
            public boolean isFound() {
                return found;
            }

            @Override
            public void throwException() {
                throw new IllegalArgumentException("Password should contain at least one special symbol");
            }

            @Override
            public void reset() {
                found = false;
            }
        };

        public abstract boolean isFound();

        public abstract void checking(char symbol);

        public abstract void throwException();

        public abstract void reset();
    }

    private static boolean allChecksIsCondition(boolean condition) {
        for (SymbolChecks check : SymbolChecks.values()) {
            if (condition != check.isFound()) {
                return false;
            }
        }
        return true;
    }

    private static void resetSymbolChecks() {
        for (SymbolChecks check : SymbolChecks.values()) {
            check.reset();
        }
    }

    private static void existsAllValidateSymbol(String password) {
        char[] chars = password.toCharArray();
        resetSymbolChecks();
        for (char symbol : chars) {
            for (SymbolChecks check : SymbolChecks.values()) {
                if (!check.isFound()) {
                    check.checking(symbol);
                }
            }
            if (allChecksIsCondition(true)) {
                return;
            }
        }
        for (SymbolChecks check : SymbolChecks.values()) {
            if (!check.isFound()) {
                check.throwException();
            }
        }
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
            throw new IllegalArgumentException("Password should be length [" + MIN_LENGTH + ", " + MAX_LENGTH + "]");
        }
        existsAllValidateSymbol(password);
        if (existsSpecialSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: " + String.join(", ", SPECIAL_SUBSTRINGS));
        }
        return password;
    }
}
