package baekjoon.part02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2-3) 백트래킹(2) : 2661번 - 좋은 수열
public class Num2661 {

    public static String result = "";
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        backtracking(n, "1", 1);

    }

    public static void backtracking(int n, String s, int current){

        if(current == n){
            result = s;
            System.out.println(s);
            System.exit(0); // 첫 번째 result값을 찾으면 시스템 즉시 종료
        }

        if(result.equals("")){
            for(int i=1; i<=3; i++){
                if(greatSequence(s + i, current)){
                    backtracking(n, s + i, current + 1); // 백트래킹을 위해 이 다음 브레이크를 넣으면 안된다.
                }
            }
        }
    }

    public static boolean greatSequence(String s, int current){

        int k = current;
        int j = k-1;
        int i = j;
        while(i >= 0){
            if(s.substring(k, current+1).equals(s.substring(i,j+1))){
                return false;
            }
            k--;
            j = k-1;
            i = j - (current - k);
        }

        return true;
    }
}
