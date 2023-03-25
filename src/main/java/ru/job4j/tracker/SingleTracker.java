package ru.job4j.tracker;

public class SingleTracker {
    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        return tracker;
    }
}
