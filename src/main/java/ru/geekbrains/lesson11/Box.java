package ru.geekbrains.lesson11;

import java.util.*;

public class Box <T extends Boxable> {
    private ArrayList<T> fruits;

    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public void add(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        float weight = 0;
        for(T fruit: fruits) {
            weight += fruit.getWeight();
        }
        return fruits.isEmpty() ? 0f : weight;
    }

    public boolean compare (Box box){
        return this.getWeight() == box.getWeight();
    }

    public void transfer (Box<T> box){
        box.fruits.addAll(this.fruits);
        fruits.clear();
    }

}







/**
 *
 * public class Box <T extends Fruit> {
 *     private ArrayList<T> fruits;
 *     private float weight;
 *
 *     public Box(T... fruits) {
 *         this.fruits = new ArrayList<>(Arrays.asList(fruits));
 *     }
 *
 *     public void add(T fruit){
 *         fruits.add((T)fruit);
 *     }
 *
 *     public float getWeight(){
 *         for(T fruit: fruits) {
 *             weight += fruit.getWeight();
 *         }
 *         return fruits.isEmpty() ? 0 : weight;
 *     }
 *
 *     public boolean compare (Box box){
 *         return getWeight() == box.getWeight();
 *     }
 *
 *     public void transfer (Box<T> box){
 *
 *         box.fruits.addAll(this.fruits);
 *         fruits.clear();
 *     }
 *
 * }
 */

/**
 * package ru.geekbrains.lesson11;
 *
 * import java.util.*;
 *
 * public class Box {
 *     private String label;
 *     private List<Fruit> fruits;
 *     private String type = "empty";
 *     private float weight;
 *
 *     public Box(String label) {
 *         this.label = label;
 *     }
 *
 *     public String getType() {
 *         return type;
 *     }
 *
 *     public void add(Fruit fruit) {
 *         if (fruits == null){
 *             fruits = new ArrayList<>();
 *             fruits.add(fruit);
 *             setType(fruit);
 * //            System.out.printf("В %s добавили %s\n", label, fruit.getType());
 *         } else if (type.equals(fruit.getType())) {
 *             fruits.add(fruit);
 * //            System.out.printf("В %s добавили %s\n", label, fruit.getType());
 *         } else System.out.printf("Нельзя добавлять %s в коробку с %s\n", fruit.getType(), type);
 *     }
 *
 *     public float getWeight () {
 *         switch (type) {
 *             case "Apple":
 *                for(Fruit fruit: fruits){
 *                     weight += fruit.getWeight();
 *                };
 *                break;
 *             case "Orange":
 *                 for(Fruit fruit: fruits){
 *                     weight += fruit.getWeight();
 *                 };
 *                 break;
 *             default:
 *                 weight = 0f;
 *         }
 *         return weight;
 *     }
 *
 *     public boolean compare(Box box){
 *         return getWeight() == box.getWeight();
 *     }
 *
 *     public void transfer (Box box){
 *         if(getType().equals(box.getType()) || box.getType().equals("empty")) {
 *             for(Fruit fruit: fruits) {
 *                 box.add(fruit);
 *             }
 *             fruits = null;
 *             type = "empty";
 *         } else System.out.println("Не та коробка.");
 *     }
 *
 *     public void setType(Fruit fruit){
 *         type = fruit.getType();
 *     }
 *
 *     protected void printInfo(){
 *         System.out.printf("В коробке %s %s, вес коробки %f\n", label, getType(), getWeight());
 *     }
 *
 * }
 */