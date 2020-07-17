package com.company.Lesson_1;

public class Man {
    private String name;
    private int run;
    private double jump;

    public Man(String name, int run, double jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    public void running(int i){
        System.out.println( run > i ? "true" : "false");
    }

    public void jumping(int i){
        System.out.println( jump > i ? "true" : "false");
    }
}
