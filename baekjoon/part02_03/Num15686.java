package baekjoon.part02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 길라잡이 2-3) 백트래킹(2) : 15686번 - 치킨 배달
public class Num15686 {

    static int result = Integer.MAX_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int chickenCount = 0;
        int homeCount =0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    homeCount++;
                }else if(arr[i][j] == 2){
                    chickenCount++;
                }
            }
        }

        int[][] chicken = new int[chickenCount][2];
        int[][] home = new int[homeCount][2];
        check = new boolean[chickenCount];


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    home[--homeCount][0] = i;
                    home[homeCount][1] = j;
                }else if(arr[i][j] == 2){
                    chicken[--chickenCount][0] = i;
                    chicken[chickenCount][1] = j;
                }
            }
        }

        choiceChicken(m, 0, chicken, home, -1);
        System.out.println(result);
    }

    public static void choiceChicken(int m, int count, int [][] chicken, int[][] home, int idx){

        if(count == m){
            int currentResult = chickenDistance(chicken, home); // 치킨집을 m개 골라서 도시의 치킨 거리 구한 것
            result = Math.min(result, currentResult);
            return;
        }

        for(int i=idx+1; i<chicken.length; i++){ // *** idx+1부터 i를 돌리고 i를 이용해서 재귀함수 부르기 ***
            check[i] = true;
            choiceChicken(m, count+1, chicken, home, i);
            check[i] = false;
        }


    }

    public static int chickenDistance(int[][] chicken, int[][] home){

        int totalDistance= 0; // ***선택된 치킨의 치킨거리의 합 // 이것들을 위해서는 minDist를 home마다 초기화 해주며 진행***

        for(int i=0; i<home.length; i++){
            int minDist = Integer.MAX_VALUE; // 각 집에 대한 치킨거리 구하기 *********
            for(int j=0; j<chicken.length; j++) {
                if (check[j]) {
                    int currentDist = Math.abs(chicken[j][0] - home[i][0]) + Math.abs(chicken[j][1] - home[i][1]);
                    minDist = Math.min(minDist, currentDist);
                }
            }
            totalDistance += minDist; // 각 집에 대한 최소의 치킨거리 총 합에 더하기 ********
        }

        return totalDistance;
    }

}
