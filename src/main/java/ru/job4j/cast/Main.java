package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle il76 = new Aircraft();
        Vehicle superjet100 = new Aircraft();
        Vehicle arctic = new Train();
        Vehicle redLine = new Train();
        Vehicle liaz = new Bus();
        Vehicle nefaz = new Bus();
        Vehicle[] vehicles = new Vehicle[]{il76, superjet100, arctic, redLine, liaz, nefaz};
        for (Vehicle a : vehicles) {
            a.move();
            a.arrive();
        }
    }
}
