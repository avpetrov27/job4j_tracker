package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[j++] = items[i];
            }
        }
        return Arrays.copyOf(result, j);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                result[j++] = items[i];
            }
        }
        return Arrays.copyOf(result, j);
    }

    public Item findById(int id) {
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                return items[index];
            }
        }
        return null;
    }
}
