package javaRevise.part01;

import java.util.Scanner;

/*
* 이소현
* 1주차 Java 미니과제 08번 : 연소득 과세금액 계산 프로그램
* */
public class Homework01_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.: ");
        int salary = sc.nextInt();

        int[] taxRate = new int[8];
        taxRate[0] = 6;
        taxRate[1] = 15;
        taxRate[2] = 24;
        taxRate[3] = 35;
        taxRate[4] = 38;
        taxRate[5] = 40;
        taxRate[6] = 42;
        taxRate[7] = 45;

        int[] taxRateResult = taxRateResult(salary);
        int deductionTax = deductionTax(salary);
        int totalTaxRateResult = 0;
        for(int i=0; i<8; i++){
            if(taxRateResult[i] != 0){
                System.out.println(taxRateResult[i] + " * " + taxRate[i] + "% = " + taxRateResult[i] / 100 * taxRate[i]);
                totalTaxRateResult += taxRateResult[i] / 100 * taxRate[i];
            }
        }
        System.out.println("\n[세율에 의한 세금]:\t\t\t" + totalTaxRateResult);
        System.out.println("[누진공제 계산에 의한 세금]:\t" + deductionTax);
    }

    public static int[] taxRateResult(int salary){

        int[] taxRateResult = new int[8];

        while(salary > 0){
            if(salary > 1000000000){
                taxRateResult[7] = (salary - 1000000000);
                salary = 1000000000;
            }else if(salary > 500000000){
                taxRateResult[6] = (salary - 500000000);
                salary = 500000000;
            }else if(salary > 300000000){
                taxRateResult[5] = (salary - 300000000);
                salary = 300000000;
            }else if(salary > 150000000){
                taxRateResult[4] = (salary - 150000000);
                salary = 150000000;
            }else if(salary > 88000000){
                taxRateResult[3] = (salary - 88000000);
                salary = 88000000;
            }else if(salary > 46000000){
                taxRateResult[2] = (salary - 46000000);
                salary = 46000000;
            }else if(salary > 12000000) {
                taxRateResult[1] = (salary - 12000000);
                salary = 12000000;
            }else {
                taxRateResult[0] = salary;
                salary = 0;
            }
        }

        return taxRateResult;
    }
    public static int deductionTax(int salary){
        int deductionTax = 0;

        if(salary > 1000000000){
            deductionTax = salary / 100 * 45 - 65400000;
        }else if(salary > 500000000){
            deductionTax = salary / 100 * 42 - 35400000;
        }else if(salary > 300000000){
            deductionTax = salary / 100 * 40 - 25400000;
        }else if(salary > 150000000){
            deductionTax = salary / 100 * 38 - 19400000;
        }else if(salary > 88000000){
            deductionTax = salary / 100 * 35 - 14900000;
        }else if(salary > 46000000){
            deductionTax = salary / 100 * 24 - 5220000;
        }else if(salary > 12000000) {
            deductionTax = salary / 100 * 15 - 1080000;
        }else {
            deductionTax = salary /100 * 6;
        }

        return deductionTax;
    }
}
