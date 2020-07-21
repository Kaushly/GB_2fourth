package com.company.Lesson_1;

public class Robot implements Actions{
    private String name;
    private int run;
    private double jump;

    public Robot(String name, int run, double jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    @Override
    public boolean jumping(int i) {
        return jump > i;
    }

    @Override
    public boolean running(int i) {
        return run > i;
    }

    @Override
    public String toString() {
        return "Robot " + name;
    }
}
