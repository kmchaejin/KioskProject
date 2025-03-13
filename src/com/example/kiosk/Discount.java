package com.example.kiosk;

import java.util.Arrays;

public enum Discount {
    NMP(1, "국가유공자", 10.0),
    SOLDIER(2, "군인", 5.0),
    STUDENT(3, "학생", 3.0),
    GENERAL(4, "일반", 0.0);

    private int caseNum;
    private String name;
    private double rate;

    Discount(int caseNum, String name, double rate){
        this.caseNum = caseNum;
        this.name = name;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public int getCaseNum() {
        return caseNum;
    }

    public String getName(){
        return name;
    }
}
