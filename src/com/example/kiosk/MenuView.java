package com.example.kiosk;

import java.util.List;

public class MenuView {
    // 메인 메뉴 출력
    public void printCategory(List<Menu> categoryList){
        System.out.println("[ Main MENU ]");

        for (int i = 0; i < categoryList.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(categoryList.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    // 특정 카테고리의 메뉴 리스트 출력
    public void printItemList(Menu menu){
        System.out.println("[ " + menu.getCategoryName().toUpperCase() + "MENU ]");

        for(int i = 0; i < menu.getItemList().size(); i++){
            System.out.print((i + 1) + ". ");
            System.out.print(menu.getItemList().get(i).getName() + " | ");
            System.out.print(menu.getItemList().get(i).getPrice() + " | ");
            System.out.println(menu.getItemList().get(i).getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }

    // 선택한 메뉴를 장바구니에 담을건지 확인하는 메뉴 출력
    public void checkSelectItem(MenuItem item){
        System.out.print("선택한 메뉴: ");
        System.out.print(item.getName() + " | ");
        System.out.print(item.getPrice() + " | ");
        System.out.println(item.getExplanation() + "\n");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.print("1. 확인\t");
        System.out.println("2. 취소");
    }
}