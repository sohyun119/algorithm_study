package baekjoon.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
// run time 에러 난 코드 다시 오답 풀이 한 코드는 다른 파일에
* 백준_2830번 : 행성 X3
* 문제)
* 상근이는 초등학교 졸업 여행으로 외계 행성 X3에 방문했었다.
* 이 행성에 사는 사람들의 이름은 모두 자연수이다. 행성의 거주민은 모두 서로를 알고 있다.
*  두 X3인은 그들의 친밀도를 자신의 이름을 이진수로 바꾸어서 계산한다.
* 두 이름을 이진수로 바꾸고, 자리수가 짧은 쪽을 기준으로 정렬한다.
*  이때, 두 이진수의 각 자리 아래에 두 자리가 같으면 0을, 다르면 1을 적는다.
*  이 결과 이진수를 다시 10진수로 바꾸면 그들의 친밀도가 된다.

예를 들어, 10과 19의 친밀도는 25이다.
* */
public class Num2830_runtimeError {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Solution sol = new Solution();
        System.out.println(sol.solution(arr));

    }
}
class Solution{
    public String toBinary(int n){
        String result = "";
        while(n > 0){
           result = Integer.toString(n % 2) + result;
           n = n/2;
        }
        return result;
    }
    public String lengthSet(String str, int maxLength){
        int newLength = maxLength - str.length();
        for(int i=0; i<newLength; i++){
            str = "0" + str;
        }
        return str;
    }
    public int toDecimal(String binaryNum){
        int len = binaryNum.length();
        int result = 0;
        for(int i=0; i<len; i++){
            result += ((int) binaryNum.charAt(i) - '0') * Math.pow(2,len-i-1);
        }
        return result;
    }

    public String comparisonBinary(String binary01, String binary02){
        String result = "";
        for(int i=0; i<binary01.length(); i++){
            if(binary01.charAt(i) != binary02.charAt(i)){
                result += "1";
            }
            else{
                 result += "0";
            }
        }
        return result;
    }

    public int solution(int[] arr){
        String[] binaryName = new String[arr.length];
        for(int i=0; i<binaryName.length; i++){
            binaryName[i] = toBinary(arr[i]);
        }
        int maxLength = binaryName[0].length();
        for(int i=0; i<binaryName.length; i++){
            if(maxLength < binaryName[i].length()){
                maxLength = binaryName[i].length();
            }
        }
        // 길이 전부다 같게 맞추기
        for(int i=0; i<binaryName.length; i++){
            binaryName[i] = lengthSet(binaryName[i], maxLength);
        }

        int answer = 0;
        for(int i=0; i<binaryName.length-1; i++){
            for(int j=i+1; j<binaryName.length; j++){
                answer += toDecimal(comparisonBinary(binaryName[i],binaryName[j]));
            }
        }


        return answer;
    }
}
