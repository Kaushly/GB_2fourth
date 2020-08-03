package com.company.Lesson_5;

public class OneTread {
    private StartArray startArray;

    public OneTread(StartArray startArray) {
        this.startArray = startArray;
    }

    public void initMethod() {
        long a = System.currentTimeMillis();

        for (int i = 0; i < startArray.getArray().length; i++) {
            startArray.array[i] = ((float) (startArray.array[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
        }
        System.out.println("Последовательно: " + (System.currentTimeMillis() - a));
    }
}
