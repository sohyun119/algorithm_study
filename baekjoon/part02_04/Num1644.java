package baekjoon.part02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 백준 길라잡이 2-4. 기초수학 (2) : 1644번 - 소수의 연속합
public class Num1644 {

    public static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2부터 n 까지 모든 소수들을 저장
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(primeNumber(i)){
                arr.add(i);
            }
        }

        sol(arr, n);
        System.out.println(count);

    }

    public static boolean primeNumber(int n){

        if(n == 2 || n == 3){
            return true;
        }
        else if(n == 1 || n % 2 == 0){
            return false;
        }
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void sol(ArrayList<Integer> arr, int n){

        /*
        for(int i=0; i < arr.size(); i++){
            int sum = 0;
            for(int j=i; j < arr.size(); j++){
                sum += arr.get(j);
                if(sum == n){
                    count++;
                    break;
                }else if(sum > n){ // ***
                    break;
                }
            }
        }*/

        // 효율을 위한 새 코드
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end <= arr.size()){
            if(sum == n){
                count++;
                sum -= arr.get(start);
                start++;
            }else if(sum > n){
                sum -= arr.get(start);
                start++;
            }else{
                if(end < arr.size()){
                    sum += arr.get(end);
                }
                end++;
            }
        }

    }
}
