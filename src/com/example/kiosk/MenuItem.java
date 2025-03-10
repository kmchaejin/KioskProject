package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    String name;
    double price;
    String explanation;
    int quantity;

    List<String> nameList = new ArrayList<>();
    List<Double> priceList = new ArrayList<>();
    List<String> explanationList = new ArrayList<>();
    List<Object> returnList = new ArrayList<>();

    public void addList(String name, double price, String explanation){
        nameList.add(name);
        priceList.add(price);
        explanationList.add(explanation);
        quantity++;
    }

    public Object getList(int index){
        returnList.clear();
        returnList.add(nameList.get(index));
        returnList.add(priceList.get(index));
        returnList.add(explanationList.get(index));

        return returnList;
    }
}
