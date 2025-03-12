package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> categoryList = new ArrayList<>();

    Kiosk(List<Menu> categoryList) {
        this.categoryList = categoryList;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        MenuView view = new MenuView();
        Cart myCart = new Cart();

        int categoryNum = 1, itemNum = 1, decisionNum;

        while (categoryNum != 0) {
            // 메인 메뉴 view 호출
            view.printCategory(categoryList);
            categoryNum = scanner.nextInt();

            // 입력값이 0이면 프로그램 종료
            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                continue;
            }

            // 입력값이 0 이하이거나 카테고리 개수보다 큰 경우 재입력
            if (categoryNum < 0 || categoryNum > categoryList.size()) {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.\n");
                continue;
            }

            while (itemNum != 0) {
                // 메뉴 리스트 view 호출
                view.printItemList(categoryList.get(categoryNum - 1));
                itemNum = scanner.nextInt();

                // 뒤로가기 선택
                if (itemNum == 0) {
                    break;
                }

                // 입력값이 0 이하이거나 메뉴 아이템 개수보다 큰 경우 재입력
                if (itemNum < 0 || itemNum > categoryList.get(categoryNum - 1).getItemList().size()) {
                    System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.\n");
                    continue;
                }

                // 장바구니에 추가할지 확인하는 view 호출
                view.checkSelectItem(categoryList.get(categoryNum - 1).getItemList().get(itemNum - 1));
                decisionNum = scanner.nextInt();

                // 1 이외의 수 입력 - 뒤로 가기 / 1 입력 - 장바구니에 추가
                if (decisionNum == 2) {
                    System.out.println("취소되었습니다.");
                } else if (decisionNum != 1) {
                    System.out.println("유효하지 않은 입력으로, 취소되었습니다.");
                } else {
                    myCart.addCartItem(categoryList.get(categoryNum - 1).getItemList().get(itemNum - 1));
                    System.out.println(categoryList.get(categoryNum - 1).getItemList().get(itemNum - 1).getName() + " 이 장바구니에 추가되었습니다.");
                    break;
                }
            }
        }

        scanner.close();
    }
}
