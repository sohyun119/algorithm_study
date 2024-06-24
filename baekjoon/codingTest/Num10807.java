package baekjoon.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
* 백준 10807번 : 개수 세기
* HashMap을 이용해서 풀었다.
*
* 문제) 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
* */
public class Num10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()){
            int temp = Integer.parseInt(st.nextToken());
            if(map.containsKey(temp)){
                map.replace(temp, map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }
        int v = Integer.parseInt(br.readLine());
        if(!map.containsKey(v)){
            System.out.println(0);
        }
        else{
            System.out.println(map.get(v));
        }

    }
}
