package baekjoon.part02_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 백준 길라잡이 2-1. 백트래킹(1) : 6603번 - 로또
public class Num6603_로또 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            int[] arr = new int[k];
            for(int i=0; i<k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sol(arr, new int[6], 0, 0);
            System.out.println();
        }

    }

    public static void sol(int[] arr, int[] selected, int start, int depth){
        // start = 시작 인덱스

        // sol(1) = 1 (+) sol(2) or 1 (+) sol(3) or ... 1 (+) sol(k-5)
        // sol(2) = 2 (+) sol(3) or 2 (2) sol(4) or ...

        if(depth ==  6){
            for(int i=0; i<6; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i < arr.length; i++){
            selected[depth] = arr[i];
            sol(arr, selected, i+1, depth + 1);
        }

    }

}
