package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> name = new ArrayList<>();
        List<Object> price = new ArrayList<>();
        List<Object> explanation = new ArrayList<>();
        List<List<Object>> list = new ArrayList<>();

        name.add("ShackBurger");
        price.add(6.9);
        explanation.add("토마토, 양상추, 쉑소스가 토핑된 치즈버거");

        name.add("SmokeShack");
        price.add(8.9);
        explanation.add("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");

        name.add("Cheeseburger");
        price.add(6.9);
        explanation.add("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");

        name.add("Hamburger");
        price.add(5.4);
        explanation.add("비프패티를 기반으로 야채가 들어간 기본버거");

        list.add(name);
        list.add(price);
        list.add(explanation);

        Kiosk kiosk = new Kiosk(list);
        kiosk.start();
    }
}
