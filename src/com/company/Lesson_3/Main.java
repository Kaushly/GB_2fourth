package com.company.Lesson_3;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Первое задание
        Array array = initArray();
        array.print();

//        Второе задание
//        PhoneBook phoneBook = initPhoneBook();
//
//        phoneBook.get("Vlad");
//        phoneBook.get("Max");
//        phoneBook.get("Lena");
    }

    private static PhoneBook initPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(1234567, "Sergey");
        phoneBook.add(5496967, "Vlad");
        phoneBook.add(234235, "Vlad");
        phoneBook.add(234, "Vlad");
        phoneBook.add(234234, "Vladislav");
        phoneBook.add(5496967, "Vlad");
        phoneBook.add(2143573, "Yura");
        phoneBook.add(1237543, "Max");
        phoneBook.add(6719253, "Danay");
        phoneBook.add(7681230, "Vlad");
        return phoneBook;
    }

    private static Array initArray() {
        Array array = new Array();
        array.add("Список");
        array.add("слов");
        array.add("которые");
        array.add("необходимо");
        array.add("написать");
        array.add("и");
        array.add("слова");
        array.add("должны");
        array.add("повторять");
        array.add("слова");
        array.add("которые");
        array.add("уже");
        array.add("есть");
        array.add("в");
        array.add("этом");
        array.add("списке");

        return array;
    }
}
