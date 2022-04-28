package ru.geekbrains.lesson10;

import java.util.*;

public class PhoneBook {
    private static PhoneBook phoneBook;
    private TreeMap<Integer, String> contacts = new TreeMap<>();

    private PhoneBook() {
    }

    public static PhoneBook getInstance() {
        if (phoneBook == null) {
            phoneBook = new PhoneBook();
        }
        return phoneBook;
    }

    public TreeMap<Integer, String> getContacts() {
        return contacts;
    }

    public void addContact (Contact contact){
        contacts.put(contact.getNumber(), contact.getName());
    }

    public void getNumber (String name) {
        List<Integer> phoneNumbers = getMatches(name);
        if(phoneNumbers.isEmpty())
            System.out.println("Matches not found");
        else
            System.out.printf("Result for %s: %s\n", name, phoneNumbers);
    }

    private List<Integer> getMatches(String name) {
        List<Integer> matches = new ArrayList<>();
        for(Map.Entry<Integer,String> entry: contacts.entrySet()){
            if (entry.getValue().equalsIgnoreCase(name))
                matches.add(entry.getKey());
        }
        return matches;
    }
}

