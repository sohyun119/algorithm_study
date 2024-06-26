package baekjoon.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 한 줄 씩 n 줄 실행
        for(int i=0; i<n; i++){
            String st = br.readLine();
            Stack<Character> stack = new Stack<>();
            String result = "YES";
            // 한 줄 실행동안
            for(int j=0; j<st.length(); j++){
                char temp = st.charAt(j);
                if(temp == '('){
                    stack.add(temp);
                }else{
                    if(stack.empty()){
                        result = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.size() > 0){
                result = "NO";
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
