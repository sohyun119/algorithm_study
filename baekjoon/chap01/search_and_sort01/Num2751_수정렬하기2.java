package baekjoon.chap01.search_and_sort01;

import java.io.*;

public class Num2751_수정렬하기2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, temp, 0, n-1);

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }

    }
    public static void mergeSort(int[] arr, int[] temp, int left, int right){

        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid+1, right);
            merge(arr, temp, left, right, mid);

        }

    }

    public static void merge(int[] arr, int[] temp, int left, int right, int mid){

        int p = left;
        int q = mid+1;
        int idx = p;

        while(p <= mid || q <= right){
            if(p <= mid && q <= right){
                if(arr[p] <= arr[q]){
                    temp[idx++] = arr[p++];
                }else{
                    temp[idx++] = arr[q++];
                }
            }else if(p <= mid){
                temp[idx++] = arr[p++];
            }else{
                temp[idx++] = arr[q++];
            }
        }

        for(int i=left; i<=right; i++){ // 이 부분에서 0부터 넣어버리는 바람에 이상하게 되었다...
            arr[i] = temp[i];
        }
    }


}
