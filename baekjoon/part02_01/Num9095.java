package baekjoon.part02_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준길라잡이 2-1) 백트래킹 : 9095번 - 1,2,3 더하기
public class Num9095 {

    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] testcases = new int[t];

        for(int i=0; i<t; i++){
            testcases[i] = Integer.parseInt(br.readLine());
        }
            /*
            해당 조합은 1이 n개 존재, 나열시 나누는 벽이 n-1개, n-2개, ..., 0개 있다고 가정
            1 + 1 + 1 + 1 : 의 경우 1이 4개 벽이 3개 // 1 + 1+ 2 : 의 경우 벽이 2개 있다고 생각
            이때 나누는 벽의 개수에 따라 몇 개의 경우가 나오는지 확인하면 됨
            생각해보면 벽의 개수는 (n-1)C(n-1) 개, (n-1)C(n-2) 개, (n-1)C(n-3) 개, ... (n-1)C(0) 개씩 나옴
            즉, 각 조합을 시그마 하면 2^(n-1)을 구하면 되는 문제이다.
            하지만 이 문제는 1,2,3만을 가지고 조합해야해서 다시 풀어야 한다.
             */
            //System.out.println((int) Math.pow(2,testcases[i]-1) - 1);

        Num9095 c = new Num9095();
        for(int i=0; i<t; i++){
            count = 0;
            c.sol(testcases[i], 1);
            c.sol(testcases[i], 2);
            c.sol(testcases[i], 3);
            System.out.println(count);
        }


    }

    public void sol(int n, int sum){

        if(sum == n){
            count++;
            return;
        }
        else if(sum > n){
            return;
        }

        sol(n, sum + 1);
        sol(n, sum + 2);
        sol(n, sum + 3);

    }

}
