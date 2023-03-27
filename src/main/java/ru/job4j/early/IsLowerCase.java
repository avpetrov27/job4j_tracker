package ru.job4j.early;

import static java.lang.Character.isLowerCase;

public class IsLowerCase implements SymbolInGroup {
    private boolean found;

    @Override
    public void isSymbolInGroup(char symbol) {
        if (!found && isLowerCase(symbol)) {
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
}
