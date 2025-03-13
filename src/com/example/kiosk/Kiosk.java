package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kiosk {
    private List<Menu> categoryList = new ArrayList<>();

    Kiosk(List<Menu> categoryList) {
        this.categoryList = categoryList;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        MenuView view = new MenuView();
        Cart myCart = new Cart();

        int categoryNum = 1, itemNum, decisionNum, orderOptionSize = 0;

        while (categoryNum != 0) {
            // 메인 메뉴 view 호출
            view.printCategory(categoryList);

            // 주문 메뉴 view 호출
            if (!myCart.getCartItemList().isEmpty()) {
                orderOptionSize = 2;
                view.printOrderMenu(categoryList);
            }

            categoryNum = scanner.nextInt();
            System.out.println();

            // 입력값이 0이면 프로그램 종료
            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                continue;
            }

            if (!myCart.getCartItemList().isEmpty()) {
                // 입력값이 4이면 최종 주문 메뉴 view 호출
                if (categoryNum == categoryList.size() + 1) {
                    view.checkOrderItems(myCart);

                    decisionNum = scanner.nextInt();
                    System.out.println();

                    // 입력값이 1이면 주문 완료 후 프로그램 종료
                    // 입력값이 2이면 메인 메뉴로 이동
                    // 입력값이 3이면 장바구니에서 SmokeShack 삭제 후 메인 메뉴로 이동
                    if (decisionNum == 1) {
                        // 할인 정보 view 호출
                        view.PrintDiscountInfo();

                        decisionNum = scanner.nextInt();

                        // 특정 enum의 할인율 적용 후 총 금액 출력
                        for (Discount e : Discount.values()) {
                            if (decisionNum == e.getCaseNum()) {
                                String formatPrice = String.format("%.2f", myCart.getTotalPrice() * (1 - e.getRate() * 0.01));
                                System.out.println("주문이 완료되었습니다. 금액은 W " + formatPrice + " 입니다.");
                                myCart.resetCartList(); // 장바구니 초기화
                            }
                        }
                        break;
                    } else if (decisionNum == 2) {
                        continue;
                    } else if (decisionNum == 3) {
                        myCart.getCartItemList().keySet().stream()
                                .filter(item -> "SmokeShack".equals(item.getName()))
                                .findFirst()
                                .ifPresent(myCart.getCartItemList()::remove);

                        System.out.println("장바구니에서 SmokeShack을 제거했습니다.\n");
                        continue;
                    } else {
                        System.out.println("유효하지 않은 값을 입력했습니다. 메인 메뉴로 돌아갑니다.\n");
                        continue;
                    }
                }

                // 입력값이 5이면 주문 취소
                if (categoryNum == categoryList.size() + 2) {
                    myCart.resetCartList();
                    System.out.println("장바구니가 초기화됩니다.\n");
                    continue;
                }
            }

            // 입력값이 0 이하이거나 카테고리 개수(+주문 메뉴 선택지 개수)보다 큰 경우 재입력
            if (categoryNum < 0 || categoryNum > categoryList.size() + orderOptionSize) {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.\n");
                continue;
            }

            while (true) {
                // 메뉴 리스트 view 호출
                view.printItemList(categoryList.get(categoryNum - 1));

                itemNum = scanner.nextInt();
                System.out.println();

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
                System.out.println();

                // 1 이외의 수 입력 - 뒤로 가기 / 1 입력 - 장바구니에 추가
                if (decisionNum == 2) {
                    System.out.println("취소되었습니다.\n");
                } else if (decisionNum != 1) {
                    System.out.println("유효하지 않은 입력으로, 취소되었습니다.\n");
                } else {
                    myCart.addCartItem(categoryList.get(categoryNum - 1).getItemList().get(itemNum - 1));
                    System.out.println(categoryList.get(categoryNum - 1).getItemList().get(itemNum - 1).getName() + " 이 장바구니에 추가되었습니다.\n");
                    break;
                }
            }
        }
        scanner.close();
    }
}
