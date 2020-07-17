package com.company.Lesson_1;

public class Robot {
    private String id;
    private int run;
    private double jump;

    public Robot(String id, int run, double jump) {
        this.id = id;
        this.run = run;
        this.jump = jump;
    }

    public boolean running(int i){
        System.out.println( run > i ? "true" : "false");
        return run > i;
    }

    public boolean jumping(int i){
        System.out.println( jump > i ? "true" : "false");
        return jump > i;
    }

    public int getRun() {
        return run;
    }

    public double getJump() {
        return jump;
    }
}
