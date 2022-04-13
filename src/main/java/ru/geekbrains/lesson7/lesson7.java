package ru.geekbrains.lesson7;


public class lesson7 {
    public static void main(String[] args) {
        Cat[] hungryCats  = new Cat[]{
                    new Cat("Barsik", -10),
                    new Cat("Ryzhik", 0),
                    new Cat("Persik", 30),
                    new Cat("Pushistik", 35),
                    new Cat("Vasiliy", 35)
            };

        Plate plate = new Plate(100);
        for (Cat cat : hungryCats) {
            cat.eat(plate);
        }
        plate.info();
        System.out.println();

        plate.addFood(100);
        hungryCats[4].eat(plate);
        hungryCats[4].eat(plate);
        hungryCats[3].eat(plate);
        plate.info();
    }
}
