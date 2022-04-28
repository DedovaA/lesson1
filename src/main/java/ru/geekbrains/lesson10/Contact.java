package ru.geekbrains.lesson10;

public class Contact {
    private Integer number;
    private String name;

    public Contact(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

}
