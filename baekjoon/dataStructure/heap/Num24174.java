//package baekjoon.dataStructure.heap;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Num24174 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int[] arr = new int[n + 1];
//        arr[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken(" "));
//        }
//
//        int[] result = heapSort(arr, n, k);
//
//        if (result == null) {
//            System.out.println(-1);
//        } else {
//            for (int i = 1; i <= n; i++) {
//                System.out.print(arr[i] + " ");
//            }
//        }
//
//    }
//
//    public static int[] heapSort(int[] arr, int n, int k) {
//        int count = 0;
//        for (int i = 1; i <= n / 2; i++) {
//            if (count == k) {
//                return arr;
//            }
//            2 5 1 4 3
//                1 5 2 4 3
//                1 3 2 4 5
//
//
//            if (i == n / 2 && n % 2 == 0) {
//                if (arr[i] > arr[i * 2]) {
//                    int temp = arr[i];
//                    arr[i] = arr[i * 2];
//                    arr[i * 2] = temp;
//                    count++;
//                    if (count == k) {
//                        return arr;
//                    }
//                    break;
//                } else {
//                    return null;
//                }
//            }
//            int node = arr[i];
//            int leftChild = arr[i * 2];
//            int rightChild = arr[i * 2 + 1];
//
//            if (leftChild <= rightChild) {
//                if (node > leftChild) {
//                    arr[i] = leftChild;
//                    arr[i * 2] = node;
//                    count++;
//                }
//            }
//            else {
//                if (node > rightChild) {
//                    arr[i] = rightChild;
//                    arr[i * 2 + 1] = node;
//                    count++;
//                }
//            }
//
//        }
//        if(count < k){
//            return null;
//        }else{
//            return arr;
//        }
//    }
//}
