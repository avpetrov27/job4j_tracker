package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Просто едет колесами по асфальту");
    }

    @Override
    public void arrive() {
        System.out.println(getClass().getSimpleName() + " Остановка улица Ленина");
    }
}
