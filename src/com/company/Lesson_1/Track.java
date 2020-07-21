package com.company.Lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Track {
    private int maxCount;
    private int numb;
    private int[] barriers;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void init() throws IOException {
        System.out.println("Как вы желаете создать полосу препятствий? 1 - случайно | 2 - самостоятельно");
        numb = Integer.parseInt(reader.readLine());
        System.out.print("Введите количество препятствий:");
        maxCount = Integer.parseInt(reader.readLine());

    }

    public void goTrack(Robot[] robots, Man[] mans, Cat[] cats, Wall wall, Road road) throws IOException {
        Actions[][] actions = {robots, mans, cats};
        switch (numb) {
            case 1:
                randomTrack(wall, road, actions);
                break;
            case 2:
                playerTrack(wall, road, actions);
        }
    }

    private void playerTrack(Wall wall, Road road, Actions[][] actions) throws IOException {
        barriers = new int[maxCount];
        for (int i = 0; i < maxCount; i++) {
            System.out.println((i + 1) + " препятствие будет: [1 - стена / 2 - дорога]");
            int num = Integer.parseInt(reader.readLine());
            switch (num) {
                case 1:
                    barriers[i] = 1;
                    break;
                case 2:
                    barriers[i] = 0;
            }
        }
        for (int barrier : barriers) {
            if (barrier == 1) {
                System.out.println("==================================");
                System.out.println("Высота стены: " + wall.getHeight());
                for (Actions[] action : actions) {
                    for (Actions act : action) {
                        if (act.jumping(wall.getHeight())) {
                            System.out.println(act + " перепрыгнул!");
                        }
                    }
                }
                wall.nextWall();
            } else {
                System.out.println("====================================");
                System.out.println("Длина дороги: " + road.getDistance());
                for (Actions[] action : actions) {
                    for (Actions act : action) {
                        if (act.running(road.getDistance())) {
                            System.out.println(act + " пробежал!");
                        }
                    }
                }
                road.nextRoad();
            }
        }
        System.out.println();
        System.out.println("Финиш");
    }

    private void randomTrack(Wall wall, Road road, Actions[][] actions) {
        for (int i = 0; i < maxCount; i++) {
            double random = Math.random();
            System.out.println("==========================");
            if (random > 0.4) {
                System.out.println((i + 1) + " препятствие: стена");
                System.out.println("Высота стены: " + wall.getHeight());
                for (Actions[] action : actions) {
                    for (Actions act : action) {
                        if (act.jumping(wall.getHeight())) {
                            System.out.println(act + " перепрыгнул!");
                        }
                    }
                }
                wall.nextWall();
            } else {
                System.out.println((i + 1) + " препятствие: дорога");
                System.out.println("Длина дороги: " + road.getDistance());
                for (Actions[] action : actions) {
                    for (Actions act : action) {
                        if (act.running(road.getDistance())) {
                            System.out.println(act + " пробежал!");
                        }
                    }
                }
                road.nextRoad();
            }
        }
        System.out.println();
        System.out.println("Финиш");
    }
}
