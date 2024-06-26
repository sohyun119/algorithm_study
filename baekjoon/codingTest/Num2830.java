package baekjoon.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Num2830 { // X3 행성
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Solution sol = new Solution();
        System.out.println(sol.solution(n, arr));

    }
}

class Solution {
    public long solution(int n, int[] arr){
        // 이진수로 변환시 각 index에 1인 경우를 담는다.
        // 이때 크기가 20인이유는 제약조건의 이름은 1000000보다 작거나 같으므로 이진수변환시 길이 20을 넘지 않는다.
        int[] count = new int[20];

        for(int i=0; i<n; i++){
            int temp = arr[i];
            int index = 0;
            while(temp > 0){
                if(temp%2 == 1){
                    count[index]++;
                }
                index++;
                temp /= 2;
            }
        }
        long answer = 0;
        // 위에서 이진수로 변환하며 각 자리에 넣은 index마다의 1의 개수와 0의 개수 그리고 2의 index을 곱한뒤 모두 더한다.
        for(int i = 0; i < 20; i++) {
            answer += (long)count[i] * (n - count[i]) * (1L << i);
        }

        return answer;
    }
}