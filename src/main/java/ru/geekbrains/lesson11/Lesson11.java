package ru.geekbrains.lesson11;

import java.util.*;

public class Lesson11 {
    public static void main(String[] args) {
        //task1
        Integer[] ints = new Integer[]{1,2,3,4,5};
        task1(ints, 0, 4);

        //task2
        Character[] characters = new Character[]{'a','b','c'};
        List<Character> list = task2(characters);
        list.add('*');
        System.out.println(list);

        //task3
        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
//        box1.add(new Orange()); // нельзя добавлять orange в apple

        Box<Orange> box2 = new Box<>(new Orange());

        Box<Apple> box3 = new Box<>(new Apple());

        System.out.println(box1.getWeight() + " " + box3.getWeight() + " " + box1.compare(box3)); // 1  1 true

        box1.transfer(box3);
//        box1.transfer(box2);   // нельзя пересыпать apple в orange

        Box<Orange> box4 = new Box<>(new Orange(), new Orange());
        box2.transfer(box4);

        System.out.println(box1.getWeight() + " " + box2.getWeight() + " " + box1.compare(box2));// 0  0 true
        System.out.println(box3.getWeight() + " " + box4.getWeight() + " " + box3.compare(box4));// 2*1  3*1.5 false
        System.out.println(box2.getWeight() + " " + box4.getWeight() + " " + box2.compare(box4));// 0  3*1.5 false


    }

    static <T> void task1 (T[] array , int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        System.out.println(Arrays.toString(array));
    }

    static <T> List task2(T[] array) {
        List<T> list = new ArrayList<>();
        for(T elem: array){
            list.add(elem);
        }
        return list;
    }


}
