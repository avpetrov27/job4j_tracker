package ru.job4j.record;

public record PersonRecord(String name, int age) {
    private static int maxAge = 100;

    public static int getMaxAge() {
        return maxAge;
    }

    public PersonRecord {
        if (age > 101) {
            throw new IllegalArgumentException("Возраст должен быть менее 101");
        }
    }

    public void info() {
        System.out.println("Напечатать информацию");
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}
