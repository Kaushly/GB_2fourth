package com.company.Lesson_5;

public class Main {
    public static void main(String[] args) {
        StartArray startArray = new StartArray();
        startArray.initArray();
        OneTread oneTread = new OneTread(startArray);
        oneTread.initMethod();
        Multithreading multithreading = new Multithreading(startArray);
        thread(multithreading);
//        for (float f : startArray.getArray()) {
//            System.out.print(f);
//        }
    }

    private static void thread(Multithreading multithreading) {
       long time = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                multithreading.doMethod1();
            }
        })
                .start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                multithreading.doMethod2();
            }
        })
                .start();
        System.out.println("Многопоточность: " + (System.currentTimeMillis() - time));
    }
}
