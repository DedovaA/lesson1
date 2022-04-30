package ru.geekbrains.lesson11;

public class Apple extends Fruit implements Boxable {

    public Apple() {
        super(1f);
    }

    @Override
    public float getWeight() {
        return weight;
    }

}
