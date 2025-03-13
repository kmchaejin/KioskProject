package com.example.kiosk;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private double totalPrice;

    private final Map<MenuItem, Integer> cartItemList = new HashMap<>();

    public void addCartItem(MenuItem item) {
        // 장바구니에 동일한 아이템이 있으면 value = value + 1
        // 장바구니에 동일한 아이템이 없으면 value = 1
        cartItemList.put(item, cartItemList.getOrDefault(item, 0) + 1);
    }

    public Map<MenuItem, Integer> getCartItemList() {
        return cartItemList;
    }

    public int getQuantity(MenuItem item) {
        return cartItemList.get(item);
    }

    public double getTotalPrice() {
        totalPrice = 0;

        for (MenuItem item : cartItemList.keySet()) {
            totalPrice += item.getPrice() * cartItemList.get(item);
        }
        return totalPrice;
    }

    public void resetCartList() {
        cartItemList.clear();
    }
}
