package com.company.Lesson_1;

public class Wall {
    private int height;
    private int count;

    public Wall(int height) {
        this.height = height;
        this.count = 1;
    }

    public void nextWall(){
        height = height + count * 10;
        count++;
    }

    public int getHeight() {
        return height;
    }
}
