package ru.job4j.cast;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Полёт нормальный.");
    }

    @Override
    public void arrive() {
        System.out.println(getClass().getSimpleName() + " Захожу на посадку.");
    }
}
