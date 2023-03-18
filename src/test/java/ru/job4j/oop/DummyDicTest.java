package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyDicTest {
    @Test
    void engToRus() {
        String in = "Word";
        DummyDic dummy = new DummyDic();
        String expected = "Неизвестное слово. Word";
        assertEquals(expected, dummy.engToRus(in));
    }
}
