package baekjoon.part02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 길라잡이 2-2) 기초 수학 : 2609번 - 최대공약수와 최소공배수
public class Num2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int gcdValue = gcd(n,m);
        int lcmValue = n*m/gcdValue;
        System.out.println(gcdValue);
        System.out.println(lcmValue);

    }
    public static int gcd(int n, int m){

        int a = n>=m?n:m;
        int b = n>=m?m:n;

        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

}
