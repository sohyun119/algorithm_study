package baekjoon.part02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 복습
public class Num14889_2 {

    static int result = Integer.MAX_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[n];
        checkStartTeam(arr, n, 0, 0); // 이때 idx=0은 startTeam에 속하지 않는 것으로 고정 : 이렇게 반 만 검사해주어도 결과는 같으므로
        System.out.println(result);


    }
    public static void checkStartTeam(int[][] arr, int n, int count, int idx){

        if(count == n/2){
            int currentPowerSum = diffPowerSum(check, arr, n);
            result = Math.min(result, currentPowerSum);
            return;
        }

        // 다음 인덱스부터 검사하는 재귀함수를 불러서 startTeam에 들어가는 경우 check를 나타내는 배열을 넘겨준다.
        for(int i=idx+1; i<n; i++){
            check[i] = true; // i가 start팀에 속하는 경우
            checkStartTeam(arr, n, count+1, i); // 재귀함수를 통해 count증가 및 다음 인덱스로 넘어간다.
            check[i] = false; // i를 포함하지 않는 경우 따로 재귀함수를 부르지 않아도 다음 반복문에서 검사하게 될 것이다.
        }

    }

    public static int diffPowerSum(boolean[] check, int[][] arr, int n){

        int startTeamPowerSum = 0;
        int linkTeamPowerSum = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(check[i] && check[j]){
                    startTeamPowerSum += (arr[i][j] + arr[j][i]);
                }
                else if(!check[i] && !check[j]){
                    linkTeamPowerSum += (arr[i][j] + arr[j][i]);
                }
            }
        }

        return Math.abs(startTeamPowerSum - linkTeamPowerSum);
    }

}
