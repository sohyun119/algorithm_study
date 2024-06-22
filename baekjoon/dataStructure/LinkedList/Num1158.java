package baekjoon.dataStructure.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Num1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> circle = new LinkedList<>();
        for(int i=1; i<=n; i++){
            circle.add(i);
        }

        int idx = 0;
        sb.append("<");
        while(!circle.isEmpty()){
            idx = (idx + k - 1) % circle.size();
            sb.append(circle.remove(idx));
            if(!circle.isEmpty()){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
