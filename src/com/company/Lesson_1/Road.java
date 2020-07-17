package com.company.Lesson_1;

public class Road {
    private int distance;
    private int count;

    public Road(int distance) {
        this.distance = distance;
        this.count = 1;
    }

    public void nextRoad(){
        distance = distance + count * 50;
        count++;
    }

    public int getDistance() {
        return distance;
    }
}
