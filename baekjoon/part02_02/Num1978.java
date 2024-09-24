package baekjoon.part02_02;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 길라잡이 : 2-2) 기초 수학 : 1978번 - 소수 찾기
public class Num1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i=0; i<n; i++){
            if(primeNumber(arr[i])){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean primeNumber(int num){

        if(num == 1 || (num != 2 && num % 2 == 0)){
            return false;
        }

        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

}
