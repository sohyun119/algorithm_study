package baekjoon.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num5613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.parseInt(br.readLine());

        while(true){
            String temp = br.readLine();
            if(temp.equals("=")){
                break;
            }else if(temp.equals("+")){
                answer += Integer.parseInt(br.readLine());
            }else if(temp.equals("-")){
                answer -= Integer.parseInt(br.readLine());
            }else if(temp.equals("*")){
                answer *= Integer.parseInt(br.readLine());
            }else if(temp.equals("/")){
                answer /= Integer.parseInt(br.readLine());
            }
        }

        System.out.println(answer);

    }
}
