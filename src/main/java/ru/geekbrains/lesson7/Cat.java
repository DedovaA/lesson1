package ru.geekbrains.lesson7;

/**
 * Если аппетит <= 0 , то кот не голоен, не ест.
 */

public class Cat {

    private String name;
    private int appetite;
    private boolean wellFed;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (appetite <= 0) {
            System.out.println(name+ " не голоден");
            return;
        }
        int beforeFeeding = plate.getFood();
        plate.decreaseFood(appetite);
        int afterFeeding = plate.getFood();
        if (beforeFeeding > afterFeeding) {
            wellFed = true;
            System.out.println(name + " наелся!");
        } else System.out.println(name + " остался голодный.");
    }
}
