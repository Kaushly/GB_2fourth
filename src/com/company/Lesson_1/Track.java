package com.company.Lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Track {
    private int maxCount;
    private int[] barriers;

    public void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите количество препятствий:");
        maxCount = Integer.parseInt(reader.readLine());
        barriers = new int[maxCount];
    }

    public void generationTrack(Robot robot, Man man, Cat cat, Wall wall, Road road) {
        for (int i = 0; i < maxCount; i++) {
            double random = Math.random();
            if (random > 0.4) {
                System.out.println((i + 1) + " препятствие: стена");
                System.out.println("Высота стены: " + wall.getHeight());
                if (robot.getJump() >= wall.getHeight() && robot.getRun() >= road.getDistance()) {
                    robot.jumping(wall.getHeight());
                }
                wall.nextWall();
            } else {
                System.out.println((i + 1) + " препятствие: дорога");
                System.out.println("Длина дороги: " + road.getDistance());
                if (robot.getJump() >= wall.getHeight() && robot.getRun() >= road.getDistance()) {
                    robot.running(road.getDistance());
                }
                road.nextRoad();
            }
        }
    }

}
