package ru.job4j.poly;

public interface Transport {
    void toDrive();

    void passengers(int count);

    float toRefuel(float volume);
}
