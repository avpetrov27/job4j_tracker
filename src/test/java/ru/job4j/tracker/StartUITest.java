package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{
                        "0", "Item name1",
                        "0", "Item name2",
                        "0", "Item name3",
                        "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name1");
        assertThat(tracker.findAll()[1].getName()).isEqualTo("Item name2");
        assertThat(tracker.findAll()[2].getName()).isEqualTo("Item name3");
        assertThat(tracker.findAll().length).isEqualTo(3);
        assertThat(tracker.findAll()[2].getId()).isEqualTo(3);
    }

    @Test
    void showAllItems() {
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item name1"));
        tracker.add(new Item("Item name2"));
        tracker.add(new Item("Item name3"));
        Input in = new StubInput(
                new String[]{
                        "0", "1", "New Item name1",
                        "0", "3", "New Item name3",
                        "0", "15", "New Item name15",
                        "1"}
        );
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(1).getName()).isEqualTo("New Item name1");
        assertThat(tracker.findById(2).getName()).isEqualTo("Item name2");
        assertThat(tracker.findById(3).getName()).isEqualTo("New Item name3");
        assertThat(tracker.findById(15)).isNull();
        assertThat(tracker.findAll().length).isEqualTo(3);
        assertThat(tracker.findAll()[2].getId()).isEqualTo(3);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item name1"));
        tracker.add(new Item("Item name2"));
        tracker.add(new Item("Item name3"));
        Input in = new StubInput(
                new String[]{
                        "0", "2",
                        "0", "42",
                        "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(2)).isNull();
        assertThat(tracker.findById(42)).isNull();
        assertThat(tracker.findById(1).getName()).isEqualTo("Item name1");
        assertThat(tracker.findById(3).getName()).isEqualTo("Item name3");
        assertThat(tracker.findAll().length).isEqualTo(2);
        assertThat(tracker.findAll()[1].getId()).isEqualTo(3);
        tracker.add(new Item("Item name4"));
        assertThat(tracker.findAll().length).isEqualTo(3);
        assertThat(tracker.findAll()[2].getId()).isEqualTo(4);
        assertThat(tracker.findById(4).getName()).isEqualTo("Item name4");
    }

    @Test
    void findItemById() {
    }

    @Test
    void findItemByName() {
    }
}