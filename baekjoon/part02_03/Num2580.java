package baekjoon.part02_03;


// 백준 길라잡이 2-3) 백트래킹 : 2580번 - 스도쿠

/*
    실수 부분 :
    1. i, j 값의 증가시 j==8 일때 i를 증가 시켰는데, 이때 j=0으로 꼭 초기화 시켜주어야 했다.
    2. 빈칸이 나와서 백트래킹을 부른 후 재귀함수가 점차 종료할때
       그 아래 game[i][j] = 0; 으로 원상복구 시켜주어야만 틀린 값이 원상복귀 되어 백트래킹이 오류 없이 돌 수 있다.!!!
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2580 {

    public static int[][] game;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        game = new int[9][9];
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);


    }

    public static void backtracking(int i, int j){

        if(i > 8){
            for(int a = 0; a < 9; a++){
                for(int b = 0; b < 9; b++){
                    System.out.print(game[a][b] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(game[i][j] == 0) {
            boolean[] existCheck = insertValue(i, j);
            // 숫자를 넣었는지 확인하는 변수
            boolean placed = false;
            for (int val = 1; val < 10; val++) {
                if (!existCheck[val]) { // 가지고 있지 않은 숫자라면
                    game[i][j] = val;
                    placed = true;
                    if(j == 8) {
                        backtracking(i + 1, 0); // 다음 행으로
                    }else{
                        backtracking(i, j+1); // 같은 행에서 다른열로
                    }
                    game[i][j] = 0; // 백트래킹을 위한 원상복구 **
                }
            }
            if(!placed){ // 넣은 숫자가 없다면 리턴 **
                return;
            }
        }
        else{
            if(j == 8){
                backtracking(i+1, 0);
            }
            else{
                backtracking(i, j+1);
            }
        }

    }

    public static boolean[] insertValue(int i, int j){

        boolean[] existCheck = new boolean[10]; // index = 0 자리는 비워둠

        for(int idx = 0; idx<9; idx++){
            // 가로줄 비교
            if(game[i][idx] != 0){
                existCheck[game[i][idx]] = true;
            }
            // 세로줄 비교
            if(game[idx][j] != 0){
                existCheck[game[idx][j]] = true;
            }
        }

        // 3*3 박스 안 비교
        for(int a = i/3 * 3; a < i/3 * 3 + 3; a++){
            for(int b = j/3 * 3; b < j/3 * 3 + 3; b++){
                if(game[a][b] != 0){
                    existCheck[game[a][b]] = true;
                }
            }
        }

        return existCheck;

    }

}
