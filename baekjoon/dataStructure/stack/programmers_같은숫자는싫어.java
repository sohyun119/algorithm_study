package baekjoon.dataStructure.stack;
import java.util.*;
public class programmers_같은숫자는싫어 {
    /*
        < 프로그래머스 : 같은 숫자는 싫어 >
        문제 분류 :  stack / queue
        주어진 배열 arr에서 연속되는 수가 있을때 숫자 하나만 남기고 전부 제거
        ex) arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return
    */
    public int[] solution(int []arr) {
        Stack stack = new Stack();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty() || ((int) stack.peek() != arr[i])) {
                stack.push(arr[i]);
                count++;
            }
        }
        int[] answer = new int[count];
        for (int i = 0; i < count; i++) {
            answer[count - 1 - i] = (int) stack.pop();
        }

        return answer;
    }
}
