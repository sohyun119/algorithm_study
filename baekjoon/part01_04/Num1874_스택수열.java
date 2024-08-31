package baekjoon.part01_04;

import java.io.*;
import java.util.Stack;

/*
 백준 길라잡이 Part01-04 기초 자료구조
 1874번 : 스택 수열
 */
public class Num1874_스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] number = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            number[i] = i+1;
        }

        StringBuilder sb = new StringBuilder(); // *** 이거 사용하기!!!
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int k = 0;
        while(idx < arr.length && k < number.length){

            if(arr[idx] == number[k]){
                stack.push(arr[idx]);

                sb.append("+\n");
                while(!stack.isEmpty() && stack.peek() == arr[idx]){
                    stack.pop();
                    sb.append("-\n");
                    idx++;
                }
                k++;
            }
            else{
                if(!stack.isEmpty() && arr[idx] < stack.peek()){
                    break;
                }

                stack.push(number[k++]);
                sb.append("+\n");
            }
        }

        if(stack.isEmpty()){
           bw.write(sb.toString());
        }
        else{
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }

}
