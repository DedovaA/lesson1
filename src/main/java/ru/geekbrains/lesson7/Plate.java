package ru.geekbrains.lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("В траелке осталось: " + food + " еды.");
    }

    public void decreaseFood(int n) {
        if (food >= n) food -= n;
        else System.out.println("В тарелке мало еды, добавьте еду в тарелку.");
    }

    public void addFood (int food) {
        this.food += food;
        System.out.println("В тарелку добавили " + food + " еды.");
    }
}
