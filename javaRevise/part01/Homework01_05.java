package javaRevise.part01;

import java.time.LocalDate;
import java.util.Scanner;

/*
    이소현
    1주차 Java 미니과제 05번 : 달력 출력 프로그램
*/
public class Homework01_05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = sc.nextInt();

        LocalDate afterDate = LocalDate.of(year,month,1).plusMonths(1);
        LocalDate lastDate = LocalDate.of(year, month, 1).minusMonths(1);
        LocalDate nowDate = LocalDate.now();

        createCalendar(lastDate.getYear(), lastDate.getMonthValue());
        createCalendar(year, month);
        createCalendar(afterDate.getYear(), afterDate.getMonthValue());

        System.out.print("\n*이번 달 달력*");
        createCalendar(nowDate.getYear(), nowDate.getMonthValue());


    }

    public static void createCalendar(int yyyy, int mm){

        System.out.println("\n["+yyyy+"년 "+mm+"월]");

        System.out.println(String.format("%c %2c %2c %-2c%-2c %-3c%-3c",'일','월','화','수','목','금','토'));

        int startDayOfWeek = LocalDate.of(yyyy, mm, 1).getDayOfWeek().getValue();
        startDayOfWeek %= 7;
        int lastDay = LocalDate.of(yyyy, mm, 1).lengthOfMonth();

        int count = 0;
        int realCount = 0;
        while(realCount < lastDay){
            if(count < startDayOfWeek){
                System.out.print("   ");
                count++;
                continue;
            }
            realCount++;
            count++;
            System.out.print(String.format("%02d ", realCount));
            if(count % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }
}
