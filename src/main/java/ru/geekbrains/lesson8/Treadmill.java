package ru.geekbrains.lesson8;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Competitor competitor) {
        return competitor.run(length);
    }
}
