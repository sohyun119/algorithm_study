package baekjoon.part01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Num10867_중복빼고정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken(" ")));
        }

        Integer[] arr = set.toArray(new Integer[set.size()]);
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

}
