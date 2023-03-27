package ru.job4j.early;

import static java.lang.Character.isLetterOrDigit;

public class IsNotLetterOrDigit implements SymbolInGroup {
    private boolean found;

    @Override
    public void isSymbolInGroup(char symbol) {
        if (!found && !isLetterOrDigit(symbol)) {
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
}
