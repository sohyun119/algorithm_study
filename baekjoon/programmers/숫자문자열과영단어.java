package baekjoon.programmers;

public class 숫자문자열과영단어 {

    class Solution {
        public int solution(String s) {
            int answer = 0;
            String str = "";
            int idx = 0;
            while(idx < s.length()){
                switch(s.charAt(idx)){
                    case 'z':
                        str += '0';
                        idx += 4;
                        break;
                    case 'o':
                        str += '1';
                        idx +=3;
                        break;
                    case 't':
                        idx++;
                        if(s.charAt(idx) == 'w'){
                            str += '2';
                            idx += 2;
                        }else{
                            str += '3';
                            idx += 4;
                        }
                        break;
                    case 'f':
                        idx++;
                        if(s.charAt(idx) == 'o'){
                            str += '4';
                            idx += 3;
                        }else{
                            str += '5';
                            idx += 3;
                        }
                        break;
                    case 's':
                        idx++;
                        if(s.charAt(idx) == 'i'){
                            str += '6';
                            idx += 2;
                        }else{
                            str += '7';
                            idx += 4;
                        }
                        break;
                    case 'e':
                        str += '8';
                        idx += 5;
                        break;
                    case 'n':
                        str += '9';
                        idx +=4;
                        break;
                    default:
                        str += s.charAt(idx);
                        idx++;
                        break;
                }
            }

            answer = Integer.parseInt(str);
            return answer;
        }
    }

}
