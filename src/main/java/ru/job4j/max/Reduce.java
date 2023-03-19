package ru.job4j.max;

public class Reduce {
    private int[] array;

    public Reduce(int[] array) {
        this.array = array;
    }

    public Reduce() {
    }

    public void to(int[] array) {
        this.array = array;
    }

    public void print() {
        for (int i : this.array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Reduce reduce = new Reduce(new int[]{1, 2, 3});
        reduce.print();
    }
}
