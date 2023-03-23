package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item(1, "Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
        assertThat(created.getId()).isEqualTo(expected.getId());
    }

    @Test
    void showAllItems() {
    }

    @Test
    void editItem() {
    }

    @Test
    void deteleItem() {
    }

    @Test
    void findItemById() {
    }

    @Test
    void findItemByName() {
    }

    @Test
    void init() {
    }
}