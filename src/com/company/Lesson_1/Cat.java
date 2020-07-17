package com.company.Lesson_1;

public class Cat {
    private String nickname;
    private int run;
    private double jump;

    public Cat(String nickname, int run, double jump) {
        this.nickname = nickname;
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
