package baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 백준 : 1021번 / 회전하는 큐
* 문제 분류 : Queue
* */
public class Num1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[m];
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque deque = new ArrayDeque();
        for(int i=1; i<=n; i++){
            deque.add(i);
        }

        int result = solution(deque, arr);
        System.out.println(result);

    }

    public static int solution(Deque deque, int[] arr){
        int result = 0;

        for(int i=0; i<arr.length; i++){
            int temp = (int)deque.peek();
            // 실행 2번을 했을 때 count 세기
            int moveLeftCnt = moveLeftCount(deque, arr[i]);
            // 되돌리기 (static 메소드라서)
            moveRightCount(deque,temp);
            // 실행 3번을 했을 때 count 세기
            int moveRightCnt = moveRightCount(deque, arr[i]);
            if(moveLeftCnt >= moveRightCnt){
                result += moveRightCnt;
            }else{
                result += moveLeftCnt;
            }
            deque.removeFirst();
        }

        return result;
    }


    public static int moveLeftCount(Deque deque, int x){
        int count = 0;
        while((int)deque.peek() != x){
            int temp = (int)deque.removeFirst();
            deque.addLast(temp);
            count++;
        }
        return count;
    }

    public static int moveRightCount(Deque deque, int x){
        int count = 0;
        while((int)deque.peekFirst() != x){
            int temp = (int)deque.removeLast();
            deque.addFirst(temp);
            count++;
        }
        return count;
    }
}
