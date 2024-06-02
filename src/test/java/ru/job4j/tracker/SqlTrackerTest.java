package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceAndCountMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item10");
        Item item1 = new Item("item11");
        tracker.add(item0);
        tracker.replace(item0.getId(), item1);
        assertThat(tracker.findById(item0.getId()).getName()).isEqualTo(item1.getName());
    }

    @Test
    public void whenDeleteAndNotFound() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item10");
        tracker.add(item0);
        tracker.delete(item0.getId());
        assertThat(tracker.findById(item0.getId())).isNull();
    }

    @Test
    public void whenDeleteOneOtherStay() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item10");
        Item item1 = new Item("item11");
        Item item2 = new Item("item12");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId())).isNull();
        assertThat(tracker.findAll().size()).isEqualTo(2);
        Assertions.assertArrayEquals(tracker.findAll().toArray(), List.of(item0, item2).toArray());
    }

    @Test
    public void whenAddSomeAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item0");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll().size()).isEqualTo(3);
        Assertions.assertArrayEquals(tracker.findAll().toArray(), List.of(item0, item1, item2).toArray());
    }

    @Test
    public void whenAddSomeAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item0");
        Item item1 = new Item("item0");
        Item item2 = new Item("item2");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        Assertions.assertArrayEquals(tracker.findByName(item0.getName()).toArray(), List.of(item0, item1).toArray());
    }

    @Test
    public void whenAddSomeAndFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item0");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item0.getId())).isEqualTo(item0);
        assertThat(tracker.findById(item1.getId())).isEqualTo(item1);
        assertThat(tracker.findById(item2.getId())).isEqualTo(item2);
    }
}
