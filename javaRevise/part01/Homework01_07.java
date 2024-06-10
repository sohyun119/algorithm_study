package javaRevise.part01;

import java.util.*;

/*
* 이소현
* 1주차 Java 미니과제 07번 : 로또 당첨 프로그램
* */
public class Homework01_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int count = sc.nextInt();
        int[][] numberArr = new int[count][6];
        for(int i=0; i<count; i++){
            System.out.print((char) (i+65) + "\t");
            String numberStr = sc.next();
            String[] temp = numberStr.split(",");
            for(int j=0; j<6; j++){
                numberArr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Set<Integer> prizeSet = new TreeSet<>();
        while(prizeSet.size() < 6){
            prizeSet.add((int)(Math.random()*45)+1);
        }
        System.out.println("\n[로또 발표]");
        System.out.println(prizeSet.toString() + "\n");

        for(int i=0; i<count; i++){
            int resultCount = 0;
            String myNumberStr = "";
            for(int j=0; j<6; j++){
                if(prizeSet.contains(numberArr[i][j])){
                    resultCount++;
                }
                myNumberStr += numberArr[i][j];
                if(j!=5){
                    myNumberStr += ",";
                }
            }
            System.out.println((char) (i+65) + "\t" + myNumberStr + " => " + resultCount + "개 일치");
        }

    }
}
