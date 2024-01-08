package ru.job4j.tracker;

public class SingleTracker {
    private static final MemTracker MEMTRACKER = new MemTracker();

    private SingleTracker() {
    }

    public static MemTracker getInstance() {
        return MEMTRACKER;
    }
}
