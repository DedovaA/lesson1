package ru.geekbrains.lesson6;

public abstract class Animal {
    private String name;
    private static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public abstract void run (int length);

    public abstract void swim (int length);

}
