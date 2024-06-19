package baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Queue는 FIFO
public class Num10845 {
    static int[] arr = new int[10001];
    static int front = 0;
   static int rear = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 여러 문자열을 합치는데 성능이 좋음 : 내부적으로 문자열을 변경할 때 새로운 객체를 생성하지 않고 기존 데이터를 변경하므로

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case"push":
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
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void push(int x){
        // 꽉 찼을 경우는 구현하지 않았음
        arr[rear] = x;
        rear += 1;
        if(rear == arr.length){
            rear = 0;
        }
    }
    public static int pop(){
        if(empty() == 1){
            return -1;
        }else{
            int temp = arr[front];
            front = front + 1;
            if(front == arr.length){
                front = 0;
            }
            return temp;
        }
    }
    public static int empty(){
        if(front == rear){
            return 1;
        }else{
            return 0;
        }
    }
    public static int size(){
        int result = 0;
        if(front <= rear){
            result = rear - front;
        } else{
            result = arr.length - front + rear;
        }
        return result;
    }
    public static int front(){
        if(front == rear){
            return -1;
        }else{
            return arr[front];
        }
    }
    public static int back(){
        if(front == rear){
            return -1;
        }else{
            return arr[rear-1];
        }
    }
}
