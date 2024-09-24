package baekjoon.part02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 길라잡이 2-2) 기초수학(1) : 1929번 - 소수 구하기
public class Num1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=m; i<=n; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(int num){
        if(num == 1 || (num !=2 && num % 2 == 0)){
            return false;
        }
        for(int i=3; i <= Math.sqrt(num); i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}
