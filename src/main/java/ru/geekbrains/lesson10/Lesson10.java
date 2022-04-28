package ru.geekbrains.lesson10;

import java.util.*;

public class Lesson10 {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "Васька","Кузя","Барсик","Мурзик","Леопольд",
                "Бегемот","Рыжик","Рыжик","Леопольд","Матроскин"
        };

        task1(strings);
        System.out.println("\n");

        task2(strings);
        System.out.println();

        PhoneBook phoneBook = PhoneBook.getInstance();
        phoneBook.addContact(new Contact(111,"Asya"));
        phoneBook.addContact(new Contact(222,"asya"));
        phoneBook.addContact(new Contact(333,"Mom"));
        phoneBook.addContact(new Contact(444,"Dad"));
        System.out.printf("All contacts from PhoneBook %s\n",phoneBook.getContacts());
        phoneBook.getNumber("Asya");
        phoneBook.getNumber("mom");
        phoneBook.getNumber("daD");
        phoneBook.getNumber("someone");
    }

    static void task1 ( String[] strings) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(strings));
        System.out.println("Unique values:");
        for(String s: set)
            System.out.printf("%s ",s);
    }

    static void task2 ( String[] strings) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            int count;
            if (map.containsKey(strings[i])) {
                count = map.get(strings[i]);
                map.put(strings[i], ++count);
            }
            else map.put(strings[i], 1);
        }
        System.out.println("With number of repetitions:");
        System.out.println(map);
    }
}
