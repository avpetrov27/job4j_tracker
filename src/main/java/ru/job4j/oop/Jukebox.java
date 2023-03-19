package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже");
            case 2 -> System.out.println("Спокойной ночи");
            default -> System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox ricatech = new Jukebox();
        ricatech.music(1);
        ricatech.music(0b10);
        ricatech.music(052);
        ricatech.music(0x2A);
        ricatech.music(-0b10);
    }
}
