package ru.job4j.early;

import static java.lang.Character.isUpperCase;

public class IsUpperCase implements SymbolInGroup {
    private boolean found;

    @Override
    public void isSymbolInGroup(char symbol) {
        if (!found && isUpperCase(symbol)) {
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
}
