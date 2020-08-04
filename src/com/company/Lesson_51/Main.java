package com.company.Lesson_51;

import java.util.Arrays;

public class Main {
    public static final int SIZE = 100000;

    public static void main(String[] args) {
        initMethod();

    }

    public static void initMethod() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long a = System.currentTimeMillis();
        singleTread(array);
        System.out.println("Последовательно: " + (System.currentTimeMillis() - a));

        long b = System.currentTimeMillis();
        multithreading(array);
        System.out.println("Многопоточность: " + (System.currentTimeMillis() - b));

    }

    private static void singleTread(float[] arr) {
        Thread th = new Thread(new CalculateToArray(arr));
        th.start();
    }

    private static void multithreading(float[] arr) {
        int h = SIZE / 2;
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread th1 = new Thread(new CalculateToArray(a1));
        Thread th2 = new Thread(new CalculateToArray(a2));

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }
}
