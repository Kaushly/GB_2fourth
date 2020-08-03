package com.company.Lesson_5;


public class StartArray {
    private final int size = 1000000;
    public float[] array;

    public StartArray() {
        this.array = new float[size];
    }

    public void initArray(){
        for (int i = 0; i < array.length; i++){
            array[i] = 1.0f;
        }
    }

    public float[] getArray() {
        return array;
    }


}
