package javaRevise.part01;

import java.util.Scanner;

/*
    이소현
    1주차 Java 미니과제 03번 : 놀이동산 입장권 계산 프로그램
*/
public class Homework01_03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자): ");
        int age= sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력): ");
        int time = sc.nextInt();
        char personOfMerit;
        while(true){
            System.out.print("국가유공자 여부를 입력해 주세요.(y/n): ");
            personOfMerit = sc.next().charAt(0);
            if(personOfMerit == 'y' || personOfMerit == 'n'){
                break;
            }
        }
        char exsitCard;
        while(true){
            System.out.print("복지카드 여부를 입력해 주세요.(y/n): ");
            exsitCard = sc.next().charAt(0);
            if(exsitCard == 'y' || exsitCard == 'n'){
                break;
            }
        }
        int pay;
        if(age < 3){
            pay = 0;
        }else if(age < 13 || time > 17){
            pay = 4000;
        }else if(personOfMerit == 'y'|| exsitCard == 'y'){
            pay = 8000;
        }else{
            pay = 10000;
        }

        System.out.println("입장료 : " + pay);
    }
}
