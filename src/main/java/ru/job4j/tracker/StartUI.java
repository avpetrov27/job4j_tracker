package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item0 = new Item();
        System.out.println(item0.getCreated().format(DateTimeFormatter
                .ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
    }
}