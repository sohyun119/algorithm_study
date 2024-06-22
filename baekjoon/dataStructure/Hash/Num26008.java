package baekjoon.dataStructure.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* 백준 26008번 : 해시해킹
* 해시함수의 개념을 다루지만 풀이방법은 수학적으로 접근해야한다.
* */
public class Num26008 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(br.readLine());

        long result = 1;
        for(int i=0; i<n-1; i++){
            result = (result * m) % 1000000007;
        }

        System.out.println(result % 1000000007);
    }
}
