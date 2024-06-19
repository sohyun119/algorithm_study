package baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10828 {
    static int[] arr = new int[100000];
    static int top = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
    public static void push(int x){
        arr[top] = x;
        top++;
    }
    public static int pop(){
        if(top == 0){
            return -1;
        } else{
            top--;
            return arr[top];
        }
    }
    public static int size(){
        return top;
    }
    public static int empty(){
        if(top == 0){
            return 1;
        }
        return 0;
    }
    public static int top(){
        if(top == 0){
            return -1;
        }
        return arr[top-1];
    }

}
