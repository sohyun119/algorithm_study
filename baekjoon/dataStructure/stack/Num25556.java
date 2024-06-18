package baekjoon.dataStructure.stack;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* 자료구조 : Stack
* 백준 25556번 문제
* 포스택
* */
public class Num25556 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());
        int[] permutation = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            permutation[i] = Integer.parseInt(st.nextToken());
        }

        boolean result = ascendingOrder(n,permutation);
        if(result){
            bw.write("YES");
        }else{
            bw.write("NO");
        }
        bw.close();

    }

    public static boolean ascendingOrder(int n, int[] permutation){
        Stack stack01 = new Stack();
        Stack stack02 = new Stack();
        Stack stack03 = new Stack();
        Stack stack04 = new Stack();

        for(int i=0; i<n; i++){
            if(stack01.empty() || (int)stack01.peek() < permutation[i]){
                stack01.push(permutation[i]);
            }else if(stack02.empty() || (int)stack02.peek() < permutation[i]){
                stack02.push(permutation[i]);
            }else if(stack03.empty() || (int)stack03.peek() < permutation[i]){
                stack03.push(permutation[i]);
            }else if(stack04.empty() || (int)stack04.peek() < permutation[i]){
                stack04.push(permutation[i]);
            }else{
                return false;
            }
        }
        // 문제에서는 되는지 안되는지만 판별하라고 했기에 여기까지이지만
        // 정렬된 값을 구하고 싶다면
        // 위에서 스택에 정리한 뒤 모든 값을 다 넣을 수 있다면
        // 4개의 스택 peek() 값을 비교하여 제일 큰 값 먼저 뒤로 배치를 반복하기
        return true;
    }
}

