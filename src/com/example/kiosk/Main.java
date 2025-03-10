package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuItem burgers = new MenuItem();
        burgers.addList("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgers.addList("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgers.addList("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgers.addList("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        // 사용자가 선택할 메뉴 번호 초기화
        int inputNum = 1;

        //  사용자가 0 입력 전까지 메뉴 선택 반복
        while (inputNum != 0) {
            System.out.println("SHAKESHACK MENU");

            // 반복하면서 리스트의 모든 인덱스에 접근 -> 모든 메뉴 출력
            for (int i = 0; i < burgers.quantity; i++) {
                System.out.print((i+1) + ". ");
                System.out.println(burgers.getList(i));
            }
            System.out.println("0. 종료");

            // 입력값이 0이면 프로그램 종료
            inputNum = scanner.nextInt();
            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
            }
            else{
                // 선택한 햄버거 정보만 출력
                System.out.println(burgers.getList(inputNum-1)+"\n");
            }
        }

        scanner.close();
    }
}
