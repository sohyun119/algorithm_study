package baekjoon.part02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 길라잡이 : 2-2) 기초 수학 : 1037번 - 약수
public class Num1037 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] divisor = new int[n];
        for(int i=0; i<n; i++){
            divisor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(divisor);

        System.out.println(divisor[0] * divisor[n-1]);

    }

}
