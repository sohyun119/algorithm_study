package javaRevise.part01;

public class multiplicationTable {

    public static void main(String[] args) {

        // Java 미니과제 1번 : 구구단 출력하기
        // 이소현

        System.out.println("[구구단 출력]");
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                System.out.print(String.format("%02d",j)+" X "+String.format("%02d",i)+" = "+String.format("%02d",i*j)+"\t");
            }
            System.out.println();
        }

    }
}
