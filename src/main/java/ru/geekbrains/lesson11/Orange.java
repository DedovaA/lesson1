package ru.geekbrains.lesson11;

public class Orange extends Fruit implements Boxable {

    public Orange() {
        super(1.5f);
    }

    @Override
    public float getWeight() {
        return weight;
    }

}
