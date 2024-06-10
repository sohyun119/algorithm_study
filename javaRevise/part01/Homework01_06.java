package javaRevise.part01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    이소현
    1주차 Java 미니과제 06번 : 가상 선거 및 당선 시뮬레이션 프로그램
* */
public class Homework01_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int voteCount = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해주세요.");
        int peopleCount = sc.nextInt();
        String[] people = new String[peopleCount];
        Map<Integer, Integer> vote = new HashMap<>();
        for(int i=0; i<peopleCount; i++){
            System.out.print((i+1) + "번째 후보자 이름을 입력해 주세요.");
            people[i] = sc.next();
            vote.put(i+1, 0);
        }

        int count = 0;
        while(count < voteCount){
            int oneVote = (int)(Math.random()*peopleCount)+1;
            int temp = vote.get(oneVote)+1;
            vote.replace(oneVote, temp);
            count++;

            System.out.println(String.format("[투표진행률]: %.2f%%, %d명 투표 => %s",(count*100.0/voteCount),count,people[oneVote-1]));
            for(int i=0; i<peopleCount; i++){
                System.out.println(String.format("[기호:%d] %s: %.2f%%\t(투표수 : %d)",i+1,people[i],(vote.get(i+1)*1.0/voteCount),vote.get(i+1)));
            }
            System.out.println();
        }

        int maxVote = 0;
        int win = 0;
        for(int i=0; i<peopleCount; i++) {
            if(maxVote < vote.get(i+1)){
                win = i+1;
                maxVote = vote.get(i+1);
            }
        }
        System.out.println("[투표결과] 당선인 : "+people[win-1]);
    }
}
