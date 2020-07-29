package com.company.Lesson_3;

import java.util.ArrayList;
import java.util.List;

public class Array implements Arr {
    List<String> list = new ArrayList<>();

    @Override
    public void add(String word) {
        list.add(word);
    }

    @Override
    public int count(String word) {
        int count = 0;
        for (String s1 : list) {
            if (word.equals(s1)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void print() {
        System.out.println(list);
        for (String s : list) {
//             пробовал через contains, создавал метод, но что-то пошло не так.
//             Понимаю, что это костыль!
            if (count(s) == 1) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
        System.out.println();
        for (String s : list) {
            System.out.printf("'%s' повторяется %s раз%n", s, count(s));
        }
        System.out.println("==============================");
        System.out.println();

    }
}
