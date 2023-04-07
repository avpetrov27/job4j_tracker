package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("1test"),
                new Item("10"),
                new Item("1T"),
                new Item("2test"),
                new Item("2test"),
                new Item("0test"),
                new Item(10, "atest"),
                new Item(""),
                new Item("atest"),
                new Item(11, "2test"),
                new Item(5, "2test")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(10, "atest"),
                new Item("atest"),
                new Item("2test"),
                new Item("2test"),
                new Item(11, "2test"),
                new Item(5, "2test"),
                new Item("1test"),
                new Item("1T"),
                new Item("10"),
                new Item("0test"),
                new Item("")
        );
        assertThat(items).containsExactlyElementsOf(expected);
    }
}
