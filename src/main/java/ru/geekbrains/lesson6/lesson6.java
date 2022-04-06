package ru.geekbrains.lesson6;

public class lesson6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1");
        Animal cat2 = new Cat("cat2");
        Animal dog1 = new Dog("Dog1");
        Animal cat3 = new Cat("cat3");
        Animal dog2 = new Dog("Dog2");
        Animal dog3 = new Dog("Dog3");
        Dog dog4 = new Dog("Dog4");

        printCount();

        cat1.swim(-5);
        cat1.run(-5);
        cat1.run(0);
        cat1.run(100);
        cat1.run(201);

        System.out.println();

        dog1.swim(-5);
        dog1.swim(0);
        dog1.swim(10);
        dog1.run(-5);
        dog1.run(0);
        dog1.run(100);
        dog1.run(501);

    }
    public static void printCount(){
        System.out.printf("Животных: %d, котов: %d, собак: %d\n\n", Animal.getCount(), Cat.getCount(), Dog.getCount());
    }

    
}
