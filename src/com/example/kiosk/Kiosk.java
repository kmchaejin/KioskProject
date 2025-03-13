package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> categoryList = new ArrayList<>();

    Kiosk(List<Menu> categoryList) {
        this.categoryList = categoryList;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        MenuView view = new MenuView();

        // 사용자가 선택할 메뉴 번호 초기화
        int categoryNum = 1;

        //  사용자가 0 입력 전까지 메뉴 선택 반복
        while (categoryNum != 0) {
            // 메인 메뉴 출력
            System.out.println("[ Main MENU ]");
            view.printCategory(categoryList);

            categoryNum = scanner.nextInt();

            // 입력값이 0이면 프로그램 종료
            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
            }
            // 입력값이 0 이하이거나 햄버거 종류보다 큰 경우 재입력
            else if (categoryNum < 0 || categoryNum > categoryList.size()) {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.\n");
            }
            // 선택한 카테고리 메뉴아이템 출력
            else {
                while (true) {
                    System.out.println("[ " + categoryList.get(categoryNum - 1).getCategoryName().toUpperCase() + "MENU ]");
                    view.printItems(categoryList.get(categoryNum - 1));

                    int itemNum = scanner.nextInt();

                    if (itemNum < 0 || itemNum > categoryList.get(categoryNum - 1).menuItems.size()) {
                        System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.\n");
                    } else if (itemNum == 0) {
                        break;
                    } else {
                        System.out.print("선택한 메뉴: ");
                        System.out.print(categoryList.get(categoryNum - 1).menuItems.get(itemNum - 1).getName() + " | ");
                        System.out.print(categoryList.get(categoryNum - 1).menuItems.get(itemNum - 1).getPrice() + " | ");
                        System.out.println(categoryList.get(categoryNum - 1).menuItems.get(itemNum - 1).getExplanation() + "\n");
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}
