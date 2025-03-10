package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] burgers = {{"ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"}, {"SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"}, {"Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"}, {"Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"}};
        int inputNum = 1;

        while (inputNum != 0) {
            System.out.println("SHAKESHACK MENU");

            // menu 출력
            for (int i = 0; i < burgers.length; i++) {
                System.out.print((i+1) + ". ");
                System.out.print(burgers[i][0] + " / ");
                System.out.print(burgers[i][1] + " / ");
                System.out.println(burgers[i][2]);
            }
            System.out.println("0. 종료");

            // 정수 입력 후, 입력값이 0이면 프로그램 종료
            inputNum = scanner.nextInt();
            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
            }
            else{
                System.out.println(burgers[inputNum-1][0]);
            }
        }

        scanner.close();
    }
}
