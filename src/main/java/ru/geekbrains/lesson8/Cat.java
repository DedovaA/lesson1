package ru.geekbrains.lesson8;

public class Cat implements Competitor {
    private int maxJump;
    private int maxRun;

    public Cat(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean run (int length) {
        if (maxRun >= length)
            System.out.printf("Кот пробежал %d м.\n", length);
        else
            System.out.println("Кот выбыл.");
        return maxRun >= length;
    }

    @Override
    public boolean jump (int height) {
        if (maxJump >= height)
            System.out.printf("Кот перепрыгнул %d м.\n", height);
        else
            System.out.println("Кот выбыл.");
        return maxJump >= height;
    }

    @Override
    public String toString() {
        return "Кот";
    }
}
