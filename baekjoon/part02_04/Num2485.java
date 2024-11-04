package baekjoon.part02_04;

// 백준 길라잡이 2-4. 기초 수학(2) : 2485번 - 가로수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Num2485 {

    public static void main(String[] args) throws IOException {

        // 총 가로수의 개수 = (max - min) / gcd(*) + 1
        // 더 심어야 하는 가로수의 개수 = 총 가로수의 개수 - 기존 가로수의 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // temp에 arr배열의 모든 수의 최대 공약수를 저장한다.
        int temp = gcd(arr[1] - arr[0], arr[2] - arr[1]);
        for(int i=3; i<n; i++){
            temp = gcd(temp, arr[i] - arr[i-1]);
        }

        System.out.println((arr[n-1] - arr[0]) / temp + 1 - n);

    }

    public static int gcd(int a, int b){
        int x = a;
        int y = b;
        if(a < b){
            x = b;
            y = a;
        }

        if(y == 1){
            return 1;
        }
        else if(x % y == 0){
            return y;
        }
        else{
            return gcd(y, x % y);
        }
    }

}
