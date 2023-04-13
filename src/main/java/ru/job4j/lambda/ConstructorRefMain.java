package ru.job4j.lambda;

import java.util.function.Function;

public class ConstructorRefMain {
    public static void main(String[] args) {
        Function<String, Model> modelConstructor = Model::new;
        Model model = modelConstructor.apply("Example");
        System.out.println("Значение равно: " + model.getName());
    }
}
