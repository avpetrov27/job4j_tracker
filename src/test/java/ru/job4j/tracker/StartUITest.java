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
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item1"));
        tracker.add(new Item("new item2"));
        tracker.add(new Item("new item3"));
        String[] answers = {
                String.valueOf(1),
                "edited item1",
                String.valueOf(3),
                "edited item3",
                String.valueOf(88),
                "edited item88"
        };
        Input input = new StubInput(answers);
        StartUI.editItem(input, tracker);
        StartUI.editItem(input, tracker);
        StartUI.editItem(input, tracker);
        assertThat(tracker.findById(1).getName()).isEqualTo("edited item1");
        assertThat(tracker.findById(3).getName()).isEqualTo("edited item3");
        assertThat(tracker.findById(2).getName()).isEqualTo("new item2");
        assertThat(tracker.findById(88)).isNull();
        assertThat(tracker.findAll().length).isEqualTo(3);
        assertThat(tracker.findAll()[2].getId()).isEqualTo(3);
    }

    @Test
    public void whenDeteleItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item1"));
        tracker.add(new Item("new item2"));
        tracker.add(new Item("new item3"));
        String[] answers = {"2", "42"};
        Input input = new StubInput(answers);
        StartUI.deteleItem(input, tracker);
        StartUI.deteleItem(input, tracker);
        assertThat(tracker.findById(2)).isNull();
        assertThat(tracker.findById(42)).isNull();
        assertThat(tracker.findById(1).getName()).isEqualTo("new item1");
        assertThat(tracker.findById(3).getName()).isEqualTo("new item3");
        assertThat(tracker.findAll().length).isEqualTo(2);
        tracker.add(new Item("new item4"));
        assertThat(tracker.findById(4)).isNotNull();
        assertThat(tracker.findAll()[2].getId()).isEqualTo(4);
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