package baekjoon.part02_01;

// 백준길라잡이 2-1) 백트래킹 : 1182번 - 부분수열의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1182 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Num1182 c = new Num1182();
        c.sol(n, s, arr, 0, 0);

        // 공집합의 경우 하나 제외
        if(s == 0) count--;

        System.out.println(count);

    }

    public void sol(int n, int s, int[] arr, int idx, int sum){
        if(idx == n){
            if(sum == s){
                count++;
            }
            return;
        }

        // 현재 원소를 포함하는 경우 // 다음 idx와 현재 합을 보낸다.
        sol(n, s, arr, idx+1, sum + arr[idx]);
        // 현재 원소를 포함하지 않는 경우
        sol(n, s, arr, idx+1, sum);
    }

}
