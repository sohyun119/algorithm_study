package baekjoon.dataStructure.queue;

import java.util.*;

class programmers_프로세스_QueueAndLinkedList {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> alphabetList = new LinkedList<>();
        Queue<Integer> importantList = new LinkedList<>();
        // 초기화
        for(int i=0; i<priorities.length; i++){
            alphabetList.add(i);
            importantList.add(priorities[i]);
        }

        while(!importantList.isEmpty()){
            int nowImportant = importantList.remove();
            int nowLocation = alphabetList.remove();
            // 현재 값보다 큰게 없다면 answer++해주고 만약 그 값이 location과 같다면 종료
            if(!isBigger(importantList, nowImportant)){
                answer++;
                if(nowLocation == location){
                    break;
                }
            }
            // 아니라면 다시 큐에 값 넣어주기
            else{
                importantList.add(nowImportant);
                alphabetList.add(nowLocation);
            }
        }
        return answer;
    }
    // 현재 추출한 원소보다 더 큰 숫자가 남아 있는지 확인하는 메서드
    public boolean isBigger(Queue<Integer> importantList, int x){
        // x보다 크거나 9보다 같거나 작은게 존재하는지 찾기
        for(int i=x+1; i<=9; i++){
            if(importantList.contains(i)){
                return true;
            }
        }
        return false;
    }

}
