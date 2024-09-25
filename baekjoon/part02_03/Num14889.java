package baekjoon.part02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 길라잡이 2-3) 백트래킹(2) : 14889번 - 스타트와 링크
public class Num14889 {

    static int diffPower = Integer.MAX_VALUE;

    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] s = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[n];
        sol(s, 0, n,0); // 0번째 포함하는 경우만 생각 : 팀을 나누었을때 0번째가 포함되는 경우와 안되는 경우의 수가 같으므로 반만 고려해주어도 결과는 같다.

        System.out.println(diffPower);
    }

    public static void sol(int[][] s, int count, int n, int idx){

        if(count == n/2){
            int partPower = diffSol(s, check, n);
            diffPower = Math.min(diffPower, partPower);
            return;
        }

        for(int i = idx+1; i<n; i++){
            check[i] = true;
            sol(s, count+1, n, i);
            check[i] = false;
        }

    }

    public static int diffSol(int[][] s, boolean[] check, int n){

        int startSum = 0;
        int linkSum = 0;

        for(int i=0; i<n; i++){
            if(check[i]){
                for(int j=i+1; j<n; j++){
                    if(check[j]){
                        startSum += (s[i][j] + s[j][i]);
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            if(!check[i]){
                for(int j=i+1; j<n; j++){
                    if(!check[j]){
                        linkSum += (s[i][j] + s[j][i]);
                    }
                }
            }
        }

        return Math.abs(linkSum - startSum);
    }

}
