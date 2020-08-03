package com.company.Lesson_5;


public class Multithreading {
    private StartArray startArray;
    private final int h;
    private float[] a1;
    private float[] a2;

    public Multithreading(StartArray startArray) {
        this.startArray = startArray;
        h = startArray.getArray().length / 2;
        a1 = new float[h];
        a2 = new float[h];
    }

    public synchronized void doMethod1() {
        System.arraycopy(startArray.getArray(), 0, a1, 0, h);
        for (int i = 0; i < h; i++) {
            a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, startArray.array, 0, h);
    }

    public synchronized void doMethod2() {
        System.arraycopy(startArray.getArray(), h, a2, 0, h);
        for (int i = 0; i < h; i++) {
            a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a2, 0, startArray.array, h, h);
    }
}
