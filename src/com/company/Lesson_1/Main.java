package com.company.Lesson_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Track track = new Track();
        track.init();
        Robot robot = new Robot("T-800", 1500, 150);
        Man man = new Man("Sergey", 1000, 50);
        Cat cat = new Cat("Tessa", 800, 100);
        Wall wall = new Wall(20);
        Road road = new Road(400);
        track.generationTrack(robot, man, cat, wall, road);
    }
}
