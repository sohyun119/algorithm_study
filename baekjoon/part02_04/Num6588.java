package baekjoon.part02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 백준 길라잡이 2-4) 기초수학(2) : 6588번 - 골드바흐의 추측
public class Num6588 {

    public static boolean[] isPrime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 0;
        while(true){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                break;
            }
            arr.add(temp);
            if(max < temp){
                max = temp;
            }
        }

        isPrime = checkPrimeNumber(max);

        for(int n : arr){
            sol(n);
        }

    }

    public static void sol(int n){

        for(int i = 3; i <= n / 2; i += 2){
            if(isPrime[i] && isPrime[n-i]){
                System.out.println(n + " = " + i + " + " + (n-i));
                return;
            }
        }
        System.out.println("Goldbach's conjecture is wrong.");
    }

    public static boolean[] checkPrimeNumber(int max){

        isPrime = new boolean[max + 1];

        for(int i = 2; i <= max; i++){
            isPrime[i] = true;
        }

        // 에라토스테네스의 체
        for(int i = 2; i*i <= max; i++){
            if(isPrime[i]){
                // j = i*i 부터 시작하는 이유 :
                // j = i * a 일때 a가 i보다 작은 수면 이미 앞에서 i의 배수이지만 다른 수의 배수이기도 해서 검사가 끝남
                for(int j = i*i; j <= max; j += i){
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

}
