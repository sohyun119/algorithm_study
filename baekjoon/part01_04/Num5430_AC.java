package baekjoon.part01_04;

import java.io.*;
import java.util.*;

// 백준 길라잡이 1-4) 기초 자료구조(2) : 5430번 - AC
public class Num5430_AC {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            boolean error = false;

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(),"[,]"); // StringTokenizer 은 구분자를 하나의 char씩 다 구분해서 분할해준다
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i=0; i<n; i++){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            p = p.replace("RR", "");

            boolean reverse = false;
            for(int c = 0; c < p.length(); c++){
                if(p.charAt(c) == 'R'){ // *** deque를 이용하여 실제로 바꾸지 않고 어디가 앞인지만 구분해준다. ***
                    reverse = !reverse;
                }else{ // 'D'
                    if(deque.isEmpty()){
                        error = true;
                        break;
                    }
                    if(reverse){
                        deque.removeLast();
                    }else{
                        deque.removeFirst();
                    }
                }
            }
            if(error){
                bw.write("error\n");
            }
            else{
                bw.write("[");
                while(!deque.isEmpty()){
                    if(reverse){
                        bw.write(deque.removeLast().toString());
                    }else{
                        bw.write(deque.removeFirst().toString());
                    }
                    if(!deque.isEmpty()){
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.close();
    }

}
