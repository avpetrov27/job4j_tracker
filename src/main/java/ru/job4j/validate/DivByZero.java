package ru.job4j.validate;

public class DivByZero {
    public static int div(int first, int second) {
        if (second == 0) {
            System.out.println("Div by 0, return def value -1");
            return -1;
        } else {
            return first / second;
        }
    }

    public static void main(String[] args) {
        int rsl = div(10, 0);
        System.out.println(rsl);
    }
}
