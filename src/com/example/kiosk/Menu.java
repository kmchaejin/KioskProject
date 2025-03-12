package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 각 객체(카테고리)에 해당되는 메뉴아이템이 리스트에 저장됨
    private final List<MenuItem> menuItems = new ArrayList<>();

    private final String categoryName;

    Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getItemList() {
        return menuItems;
    }
}
