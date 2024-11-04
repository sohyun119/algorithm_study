package baekjoon.part02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 길라잡이 2-4) 기초수학(2) : 15711번 - 환상의 짝꿍
public class Num15711 {
    // ********** 틀림 다시 ***********
    // ****** 입력 수가 커서 안됨 ******** <- 따라서 다른 방법으로 풀어야함


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        long[] arr = new long[testCase];

        long maxNum = 0;
        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(maxNum < a+b){
                maxNum = a+b;
            }
            arr[i] = a+b;
        }


        for(long sum : arr){
            boolean check = false;
            for(long i=2; i <= sum/2; i += 2){
                if(isPrime(i) && isPrime(sum - i)){
                    System.out.println("YES");
                    check = true;
                    break;
                }
                if(i == 2){
                    i--;
                }
            }
            if(!check){
                System.out.println("NO");
            }
        }


    }

    public static boolean isPrime(long num){

        if(num == 2 || num == 3 || num == 5){
            return true;
        }
        else if(num == 1 || num % 2 == 0){
            return false;
        }
        else{
            for(int i=3; i*i <= num; i+=2){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }

    }

}
