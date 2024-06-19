package baekjoon.dataStructure.queue;
import java.util.*;
public class programmers_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        // queue에 각 걸리는 일 수 저장
        Queue days = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int temp = (100 - progresses[i]) / speeds[i];
            if(((100 - progresses[i]) % speeds[i]) > 0){
                temp += 1;
            }
            days.add(temp);
        }

        // queue의 첫 번째 값으로 가져와서 셋팅
        int maxDays = (int)days.remove();
        int count = 1;
        Queue resultQueue = new LinkedList<>();
        // days queue의 원소가 다 나올때까지
        while(!days.isEmpty()){
            int temp = (int) days.remove();
            // maxDays보다 현재 빼온 값이 작거나 같으면 한 번에 배포하므로 count +1
            if(maxDays >= temp){
                count++;
            }
            // 아니면 끊고 배포 후 다시 집개 시작
            else{
                resultQueue.add(count);
                maxDays = temp;
                count = 1;
            }
        }
        resultQueue.add(count);

        //System.out.println("result = "+resultQueue);
        int[] answer = new int[resultQueue.size()];

        for(int i=0; i<answer.length; i++){
            answer[i] = (int)resultQueue.remove();
        }
        return answer;
    }

}
