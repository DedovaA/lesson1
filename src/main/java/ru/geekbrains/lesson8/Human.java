package ru.geekbrains.lesson8;

public class Human implements Competitor {
    private int maxJump;
    private int maxRun;
    private boolean result;

    public Human(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean run(int length) {
        result = maxRun >= length;
        if (result) System.out.printf("Человек пробежал %d м.\n", length);
        else System.out.println("Человек выбыл.");
        return result;
    }

    @Override
    public boolean jump(int height) {
        result = maxJump >= height;
        if (result) System.out.printf("Человек перепрыгнул %d м.\n", height);
        else System.out.println("Человек выбыл.");
        return result;
    }

    @Override
    public String toString() {
        return "Человек";
    }
}
