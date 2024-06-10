package baekjoon.chap01.search_and_sort01;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1920_수찾기 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        for(int i=0; i<m; i++){
            int num = arr2[i];
            boolean result = binarySerch(0, n, num, arr1);
            if(result){
                System.out.println(1);
            }else{
                System.out.println(0);
                //bw.write(0);
            }
        }
        bw.close();


    }

    public static boolean binarySerch(int first, int last, int num, int[] arr1){
        int mid = (first+last)/2;
        if(first > last){
            return false;
        }
        else if(arr1[mid] == num){
            return true;
        }else if(arr1[mid] < num){
            return binarySerch(mid+1, last-1, num, arr1);
        }else{
            return binarySerch(first, mid-1, num, arr1);
        }
    }

    

}
