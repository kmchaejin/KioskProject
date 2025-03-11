package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    String name;
    double price;
    String explanation;

    public void setItem(String name, double price, String explanation){
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public String getName(){
        return name;
    }
//    public void setName(String name) {
//        this.name = name;
//    }

    public double getPrice(){
        return price;
    }
//    public void setPrice(double price) {
//        this.price = price;
//    }

    public String getExplanation(){
        return explanation;
    }
//    public void setExplanation(String explanation) {
//        this.explanation = explanation;
//    }
}
