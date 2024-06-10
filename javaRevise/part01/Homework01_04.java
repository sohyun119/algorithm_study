package javaRevise.part01;

import java.util.Random;
import java.util.Scanner;

/*
    이소현
    1주차 Java 미니과제 4번 : 주민등록번호 생성 프로그램
*/
public class Homework01_04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy): ");
        int year = sc.nextInt();
        System.out.print("출생월을 입력해주세요.(mm): ");
        int month = sc.nextInt();
        System.out.print("출생일을 입력해주세요.(dd): ");
        int day = sc.nextInt();
        System.out.print("성별을 입력해 주세요.(m/f): ");
        char gender = sc.next().charAt(0);

        String idCardNumber = year+""+String.format("%02d",month)+""+String.format("%02d",day)+"-";

        if(gender == 'm'){
            idCardNumber+='3';
        }else{
            idCardNumber+='4';
        }

        int randomVal = (int)(Math.random()*999999) + 1;
        idCardNumber += String.format("%02d",randomVal);
        System.out.println(idCardNumber);
    }
}

