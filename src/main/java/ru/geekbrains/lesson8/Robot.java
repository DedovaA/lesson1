package ru.geekbrains.lesson8;

public class Robot implements Competitor {
    private int maxJump;
    private int maxRun;
    private boolean result;

    public Robot(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean run(int length) {
        result = maxRun >= length;
        if (result)
            System.out.printf("Робот пробежал %d м.\n", length);
        else
            System.out.println("Робот выбыл.");
        return result;
    }

    @Override
    public boolean jump(int height) {
        result = maxJump >= height;
        if (result)
            System.out.printf("Робот перепрыгнул %d м.\n", height);
        else
            System.out.println("Робот выбыл.");
        return result;
    }

    @Override
    public String toString() {
        return "Робот";
    }
}
