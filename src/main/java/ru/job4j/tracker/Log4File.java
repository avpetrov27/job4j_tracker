package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Log4File {
    private static Log4File instance = null;
    private List<String> messages = new ArrayList<>();
    private int index = 0;

    private Log4File() {
    }

    public static Log4File getInstance() {
        if (instance == null) {
            instance = new Log4File();
        }
        return instance;
    }

    public void add(String message) {
        messages.add(message);
    }

    public void save() {
    }
}
