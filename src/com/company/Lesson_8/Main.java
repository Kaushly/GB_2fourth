package com.company.Lesson_8;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList names = new DoubleLinkedList();
        names.add("Mike");
        names.add("John");
        names.add("Jakub");
        System.out.println(names);
        // code....
//        names.add("Marry");
//        names.add("Kaizerine");
//        System.out.println(names);
//
//        names.add(5, "Tomas");
//        names.add(4, "UPD");
//        names.add(1, "UPD1");
//        names.add(10, "NEW");
//        System.out.println(names);

        System.out.println("Size: " + names.size());

        DoubleLinkedList.Iterator iterator = names.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
    }
}