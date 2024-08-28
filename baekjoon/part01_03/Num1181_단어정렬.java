package baekjoon.part01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// 백준길라잡이 1-3 탐색과 정렬 : 단어 정렬
public class Num1181_단어정렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        String[] arr = set.toArray(new String[set.size()]);
        Arrays.sort(arr, new myComparator());

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

}

class myComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        int temp = 0;

        if(s1.length() == s2.length()){
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    temp =  (int)s1.charAt(i) - (int)s2.charAt(i);
                    break;
                }
            }
        }else{
            temp =  s1.length()  - s2.length();
        }
        return temp;
    }
}