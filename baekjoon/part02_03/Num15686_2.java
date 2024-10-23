package baekjoon.part02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15686번 - 복습
public class Num15686_2 {

    static boolean[] check;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> chicken = new ArrayList<>();
        List<int[]> home = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 2){
                    chicken.add(new int[]{i, j});
                }
                else if(temp == 1){
                    home.add(new int[]{i, j});
                }
            }
        }

        check = new boolean[chicken.size()];
        choiceChicken(m, 0,0, chicken, home);
        System.out.println(result);

    }
    public static void choiceChicken(int m, int count, int idx, List<int[]> chicken, List<int[]> home){

        if(count == m){
            int currentDist = distance(chicken, home);
            result = Math.min(result, currentDist);
            return;
        }

        for(int i=idx; i<chicken.size(); i++){
            check[i] = true;
            choiceChicken(m, count+1, i+1, chicken, home);
            check[i] = false;
        }

    }


    public static int distance(List<int[]> chicken, List<int[]> home){
        int totalSum = 0;

        for(int i=0; i<home.size(); i++){
            int minSum = Integer.MAX_VALUE;
            for(int j=0; j<chicken.size(); j++){
                if(check[j]){
                    minSum = Math.min(minSum, Math.abs(chicken.get(j)[0] - home.get(i)[0]) + Math.abs(chicken.get(j)[1] - home.get(i)[1]));
                }
            }
            totalSum += minSum;
        }

        return totalSum;
    }

}
