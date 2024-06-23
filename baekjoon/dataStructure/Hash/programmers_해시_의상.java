package baekjoon.dataStructure.Hash;
import java.util.*;

public class programmers_해시_의상 {


    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> clothesMap = new HashMap<>();
            for(int i=0; i<clothes.length; i++){
                if(clothesMap.containsKey(clothes[i][1])){
                    int temp = clothesMap.remove(clothes[i][1]) + 1;
                    clothesMap.put(clothes[i][1], temp);
                }else{
                    clothesMap.put(clothes[i][1], 1);
                }
            }

            Collection<Integer> values = clothesMap.values();

            for(Integer val : values){
                answer *= (val + 1);
            }
            answer--;
            return answer;
        }
    }
}
