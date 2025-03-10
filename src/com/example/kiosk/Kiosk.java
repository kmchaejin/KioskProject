package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<List<Object>> menuItems = new ArrayList<>();

    Kiosk(List<List<Object>> list) {
        this.menuItems = list;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // 사용자가 선택할 메뉴 번호 초기화
        int inputNum = 1;

        //  사용자가 0 입력 전까지 메뉴 선택 반복
        while (inputNum != 0) {
            System.out.println("SHAKESHACK MENU");

            /*
            반복하면서 리스트의 모든 인덱스에 접근 -> 모든 메뉴 출력
            row 1: ["ShackBurger", "SmokeShack", "Cheeseburger", ...]
            row 2: [6.9, 8.9, 6.9, ...]
            */
            for (int col = 0; col < menuItems.get(0).size(); col++) {
                    System.out.print((col + 1) + ". | ");
                for (int row = 0; row < menuItems.size(); row++) {
                    System.out.print(menuItems.get(row).get(col));
                    System.out.print(" | ");
                }
                System.out.println();
            }
            System.out.println("0. 종료");

            inputNum = scanner.nextInt();

            // 입력값이 0이면 프로그램 종료
            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
            }
            // 입력값이 0 이하이거나 햄버거 종류보다 큰 경우 재입력
            else if(inputNum < 0 || inputNum > menuItems.get(0).size()){
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.\n");
                continue;
            }else {
                // 선택한 햄버거 정보만 출력
                for(int row = 0; row < menuItems.size(); row++){
                    System.out.print(menuItems.get(row).get(inputNum-1) + "  ");
                }
                System.out.println("\n");
            }
        }
        scanner.close();
    }
}
