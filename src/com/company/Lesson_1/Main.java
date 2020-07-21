package com.company.Lesson_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        game();
    }

    public static void game() throws IOException {
        Track track = new Track();
        track.init();
        Robot[] robots = {
                new Robot("T-800", 1500, 150),
                new Robot("T-2000", 2000, 300),
                new Robot("T-300", 400, 150)
        };
        Man[] mans = {
                new Man("Sergey", 1000, 50),
                new Man("Lena", 800, 45),
                new Man("Kira", 500, 30)
        };
        Cat[] cats = {
                new Cat("Tessa", 800, 100),
                new Cat("Kudablya", 400, 200)
        };
        Wall wall = new Wall(20);
        Road road = new Road(400);
        track.goTrack(robots, mans, cats, wall, road);
    }
}
