package baekjoon.part01_04;

import java.io.*;
import java.util.*;

// 백준 길라잡이 1-4 기초 자료구조 : 1966번 프린터 큐
public class Num1966_프린터큐 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            LinkedList<Integer> que = new LinkedList<>(); // queue 대신 이용 : 뒤에 i번째를 get 해야하므로
            LinkedList<Integer> num = new LinkedList<>();
            for(int j=0; j<n; j++){
                que.add(Integer.parseInt(st.nextToken()));
                num.add(j);
            }

            int count = 0;
            while(!que.isEmpty()){

                int front = que.peek();
                int idx = num.peek();
                boolean isMax = true;

                for(int j=0; j<que.size(); j++){
                    if(front < que.get(j)){
                        isMax = false;
                        for(int k=0; k<j; k++){
                            que.add(que.remove());
                            num.add(num.remove());
                        }
                        break;
                    }
                }

                if(isMax){
                    count++;
                    if(idx == m){
                        bw.write(count + "\n");
                        break;
                    }
                    que.remove();
                    num.remove();
                }

            }
        }

        bw.close();

    }

}
