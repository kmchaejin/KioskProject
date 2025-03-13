package com.example.kiosk;

public enum Discount {
    NMP("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0);

    final String name;
    final int rate;

    Discount(String name, int rate){
        this.name = name;
        this.rate = rate;
    }
}
