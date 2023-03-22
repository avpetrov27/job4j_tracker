package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private static boolean validate(int matches, int count) {
        if (matches < 1 || matches > 3) {
            System.out.println("Введённое количество должно находится в пределах"
                    + " от 1 до 3 (включительно).");
        } else if (count < matches) {
            System.out.println("Введённое количество не может быть больше числа "
                    + "оставшихся спичек");
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + ", введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (validate(matches, count)) {
                count -= matches;
                turn = !turn;
            }
            System.out.println("Количество оставшихся спичек: " + count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
