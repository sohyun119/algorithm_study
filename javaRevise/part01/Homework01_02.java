package javaRevise.part01;

import java.util.Scanner;

/*
    이소현
    1주차 Java 미니과제 02번 : 결제 금액 캐시백 계산 프로그램
* */
public class Homework01_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액) : ");
        long pay = sc.nextLong();
        int cashback = (int)pay/1000 * 100;
        if(cashback > 300){
            cashback = 300;
        }

        System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 " + cashback + "원 입니다.");
    }
}
