package ru.job4j.poly;

public class Service {
    private FileStore store;

    public Service(FileStore store) {
        this.store = store;
    }

    public void add() {
        store.save("Petr Arsentev");
    }

    public static void main(String[] args) {
        FileStore store = new FileStore("1");
        Service service = new Service(store);
        service.add();
    }
}
