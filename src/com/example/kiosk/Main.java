package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu burger = new Menu("Burger");
        Menu beverage = new Menu("Beverage");

        MenuItem item1 = new MenuItem();
        item1.setItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burger.addMenuItem(item1);

        MenuItem item2 = new MenuItem();
        item2.setItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burger.addMenuItem(item2);

        MenuItem item3 = new MenuItem();
        item3.setItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burger.addMenuItem(item3);

        MenuItem item4 = new MenuItem();
        item4.setItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        burger.addMenuItem(item4);

        // 생성된 카테고리를 리스트에 담아서 Kiosk에 전달
        List<Menu> categoryList = new ArrayList<>();
        categoryList.add(burger);
        categoryList.add(beverage);

        Kiosk kiosk = new Kiosk(categoryList);
        kiosk.start();
    }
}
