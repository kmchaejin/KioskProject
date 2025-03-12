package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String name;
    private double price;
    private int quantity;
    private double totalPrice;

    private List<MenuItem> cartItemList = new ArrayList<>();

    public void addCartItem(MenuItem item){
        cartItemList.add(item);
    }

    public List<MenuItem> getCartItemList() {
        return cartItemList;
    }
}
