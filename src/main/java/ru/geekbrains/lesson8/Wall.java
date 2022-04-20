package ru.geekbrains.lesson8;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Competitor competitor) {
        return competitor.jump(height);
    }
}
