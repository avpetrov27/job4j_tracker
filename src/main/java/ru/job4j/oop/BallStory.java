package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        kolobok.tryRun(false);
        System.out.println("от бабушки и дедушки.");
        hare.tryEat(kolobok);
        System.out.println("от зайца.");
        wolf.tryEat(kolobok);
        System.out.println("от волка.");
        fox.tryEat(kolobok);
        System.out.println("лисой!");
    }
}
