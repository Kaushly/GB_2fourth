package com.company.Lesson_3;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook implements PhoneInterface {
    private Map<Integer, String> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    @Override
    public void add(Integer number, String name) {
        phoneBook.put(number, name);
    }

    @Override
    public void get(String name) {
        for (Map.Entry map : phoneBook.entrySet()) {
            if (map.getValue().equals(name)) {
                System.out.println(String.format("Phone: %-20s | Name: %s", map.getKey(), map.getValue()));
            }
        }
    }

}
