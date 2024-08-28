package baekjoon.part01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num11650_좌표정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, new coordinateComparator());

        for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }

}
class coordinateComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2){
        if(o1[0] != o2[0]){
            return o1[0] - o2[0];
        }else{
            return o1[1] - o2[1];
        }
    }

}
