package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Чух-чух, чух-чух");
    }

    @Override
    public void arrive() {
        System.out.println(getClass().getSimpleName() + " Поезд Калининград-Владивосток прибывет к 1-ой платформе");
    }
}
