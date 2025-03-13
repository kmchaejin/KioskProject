package com.example.kiosk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MenuView {
    // 메인 메뉴 출력
    public void printCategory(List<Menu> categoryList) {
        System.out.println("[ MAIN MENU ]");

        IntStream.range(0, categoryList.size())
                .forEach(i -> {
                    System.out.print((i + 1) + ". ");
                    System.out.println(categoryList.get(i).getCategoryName());
                });

        System.out.println("0. 종료");
    }

    // 특정 카테고리의 메뉴 리스트 출력
    public void printItemList(Menu menu) {
        System.out.println("[ " + menu.getCategoryName().toUpperCase() + " MENU ]");

        IntStream.range(0, menu.getItemList().size())
                .forEach(i -> {
                    System.out.print((i + 1) + ". ");
                    System.out.print(menu.getItemList().get(i).getName() + " | ");
                    System.out.print(menu.getItemList().get(i).getPrice() + " | ");
                    System.out.println(menu.getItemList().get(i).getExplanation());
                });

        System.out.println("0. 뒤로가기");
    }

    // 선택한 메뉴를 장바구니에 담을건지 확인하는 메뉴 출력
    public void checkSelectItem(MenuItem item) {
        System.out.print("선택한 메뉴: ");
        System.out.print(item.getName() + " | ");
        System.out.print(item.getPrice() + " | ");
        System.out.println(item.getExplanation() + "\n");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.print("1. 확인\t");
        System.out.println("2. 취소");
    }

    // 주문 메뉴 출력
    public void printOrderMenu(List<Menu> categoryList) {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println((categoryList.size() + 1) + ". Orders\t| 장바구니를 확인 후 주문합니다.");
        System.out.println((categoryList.size() + 2) + ". Cancel\t| 장바구니를 초기화합니다.");
    }

    // 최종 주문 메뉴 출력
    public void checkOrderItems(Cart cart) {
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");

        cart.getCartItemList().keySet().stream()
                .forEach( item -> {
                    System.out.println(item.getName() + " | " + item.getPrice() + " | " + cart.getQuantity(item) + "개 | " + item.getExplanation());
                });

        System.out.println("\n[ Total ]");
        System.out.println("W " + String.format("%.2f", cart.getTotalPrice()) + "\n");

        System.out.print("1. 주문\t");
        System.out.print("2. 메뉴판\t");
        System.out.println("3. SmokeShack을 장바구니에서 제거");
    }

    // 할인 정보 출력
    public void PrintDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요.");

        System.out.println(Discount.NMP.getCaseNum() + ". " + Discount.NMP.getName() + " : " + Discount.NMP.getRate() + " %");
        System.out.println(Discount.SOLDIER.getCaseNum() + ". " + Discount.SOLDIER.getName() + " : " + Discount.SOLDIER.getRate() + " %");
        System.out.println(Discount.STUDENT.getCaseNum() + ". " + Discount.STUDENT.getName() + " : " + Discount.STUDENT.getRate() + " %");
        System.out.println(Discount.GENERAL.getCaseNum() + ". " + Discount.GENERAL.getName() + " : " + Discount.GENERAL.getRate() + " %");
    }
}