package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(minus(100));
        Calculator citizen = new Calculator();
        System.out.println(citizen.multiply(100));
        System.out.println(citizen.divide(100));
        System.out.println(citizen.sumAllOperation(100));
    }
}
