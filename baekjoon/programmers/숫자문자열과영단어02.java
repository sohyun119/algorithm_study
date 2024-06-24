package baekjoon.programmers;

public class 숫자문자열과영단어02 {

    class Solution {
        public int solution(String s) {
            int answer = 0;

            String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};

            for(int i=0; i<=9; i++){
                if(s.contains(numbers[i])){
                    s = s.replace(numbers[i], Integer.toString(i));
                }
            }
            answer = Integer.parseInt(s);
            return answer;
        }
    }

}
