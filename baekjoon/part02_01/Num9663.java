package baekjoon.part02_01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 길라잡이 2-1) 백트래킹 : 9663번 - N-Queen
public class Num9663 {

    static int[] board = {};
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n];

        nQueen(n, 0);

        System.out.println(count);

    }

    public static void nQueen(int n, int row){
        if(row == n){
            count++;
            return;
        }
        // 열과 대각선방향에서 유망한지를 체크한뒤, 행을 증가시킨다 (따라서 행은 따로 검사하지 않아도 됨)
        for(int i=0; i<n; i++){

            board[row] = i; // row행에 0~n-1까지 대입해보며 그 행에 어떤 열들이 들어 올 수 있는지 체크

            if(isPromising(board, row)){
                nQueen(n, row+1);
            }

        }
    }

    public static boolean isPromising(int[] board,int row){

        for(int i=0; i<row; i++){
            // 열이 같거나 대각선에 있는 경우를 걸러냄
            if(board[i] == board[row] || row-i == Math.abs(board[i]-board[row])){
                return false;
            }
        }

        return true;

    }


}
