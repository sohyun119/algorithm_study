package baekjoon.dataStructure.array;
import java.util.Arrays;
public class programmers_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor != 0){
                arr[i] = -1;
            }else{
                count++;
            }
        }
        if(count == 0){
            int[] result = {-1};
            return result;
        }
        int[] answer = new int[count];
        Arrays.sort(arr);
        // 만약 arr 그대로 오름차순으로 정렬하려면
        // 재귀함수 이용해서 배열의 작은값부터 찾아서 저장하기(?)
        // ㄴ 이렇게는 안하고 그냥 sort쓰는게 일반적인 것 같다.
        // * 내림차순은 sort 함수 내에서 Collections.reverOrder() 함수 쓰기

        for(int i=0; i<count; i++){
            answer[i] = arr[arr.length-count+i];
        }

        return answer;
    }

}
