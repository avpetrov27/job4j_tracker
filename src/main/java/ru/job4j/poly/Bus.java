package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void toDrive() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пасажиров: " + count);
    }

    @Override
    public float toRefuel(float volume) {
        return volume * 50;
    }
}
