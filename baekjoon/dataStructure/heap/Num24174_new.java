package baekjoon.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    int count = 0;
    int k;
    int[] arr;

    public Solution(int[] arr, int k){
        this.arr = arr;
        this.k = k;
    }

    public String solution(){
        try{
            heapSort(arr);
        }catch (Exception e){
            return toString();
        }
        return "-1";
    }

    public void heapSort(int[] arr){
        int n = arr.length -1;
        buildMinHeap(arr, n);
        for(int i=n; i>=2; i--){
            swap(arr,1,i);
            heapify(arr, 1, i-1);
        }
    }
    public void buildMinHeap(int[] arr, int n){
        for(int i=n/2; i>=1; i--){
            heapify(arr, i, n);
        }
    }
    public void heapify(int[] arr, int node, int n){
        // 주어진 node를 루트로 하는 트리의 최소 힙 성질을 만족하도록 한다.
        int smaller = 0;
        int left = 2 * node;
        int right = 2 * node + 1;
        if(right <= n){
            if(arr[left] < arr[right]){
                smaller = left;
            }else{
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else{
            return;
        }
        // arr[node]를 루트로 하는 트리를 최소 힙 성질을 만족하도록 수정한다.
        // arr[node]의 두 자식을 루트로 하는 서브 트리는 최소 힙 성질을 만족하고 있다.
        // n은 배열 arr의 전체 크기이며 최대 인덱스를 나타낸다.
        if(arr[smaller] < arr[node]){
            swap(arr, smaller, node);
            // smaller가 루트노드가 되어 재귀함수 실행
            heapify(arr, smaller, n);
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        if(++count == k){
            throw new RuntimeException(); //
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

}
public class Num24174_new {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        System.out.println(new Solution(arr, k).solution());
    }
}
