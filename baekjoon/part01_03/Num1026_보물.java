package baekjoon.part01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.reverseOrder;

// 백준길라잡이 part01_03 탐색과 정렬 : 1026 보물
public class Num1026_보물 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        Integer[] b = new Integer[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, (o1,o2)->o2-o1);

        int answer = 0;
        for(int i=0; i<n; i++){
            answer += a[i]*b[i];
        }

        System.out.println(answer);

    }

}
