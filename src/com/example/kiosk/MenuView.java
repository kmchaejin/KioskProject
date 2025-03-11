package com.example.kiosk;

import java.util.List;

public class MenuView {
    void printCategory(List<Menu> categoryList){
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(categoryList.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    void printItems(Menu menu){
        for(int i = 0; i < menu.getItemList().size(); i++){
            System.out.print((i + 1) + ". ");
            System.out.print(menu.getItemList().get(i).getName() + " | ");
            System.out.print(menu.getItemList().get(i).getPrice() + " | ");
            System.out.println(menu.getItemList().get(i).getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }
}