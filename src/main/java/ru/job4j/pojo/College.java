package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student0 = new Student();
        student0.setFullName("Петров Александр Валерьевич");
        student0.setGroup("АУ-05");
        student0.setEnrolled(new Date(1125522000000L));
        System.out.println(student0.getFullName());
        System.out.println(student0.getGroup());
        System.out.println(student0.getEnrolled());
    }
}
