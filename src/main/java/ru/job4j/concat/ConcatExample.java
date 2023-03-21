package ru.job4j.concat;

public class ConcatExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "abc".concat("def").concat("ghi").concat("jkl");
        System.out.println(str);
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
    }
}
