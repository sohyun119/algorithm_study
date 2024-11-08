package baekjoon.part02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

// 백준 길라잡이 2-4) 기초수학(2) : 15711번 - 환상의 짝꿍
public class Num15711_NotAnswer {
    // ********** 틀림 다시 ***********
    // ****** 입력 수가 커서 안됨 ******** <- 따라서 다른 방법으로 풀어야함
    // 밀러-라빈 (10^9 이상의 큰 수의 소수 판별시 사용) 사용하여 소수를 판별해야 한다.

    // ㄴ 아님 밀러-라빈 사용 해서 푸는게 아님 (왜냐하면 두 수 의 소수 조합을 생각해야해서)
    // 따라서 아래 코드는 그냥 밀러-라빈 공부용으로 남겨두기


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        long[] arr = new long[testCase];
        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
        }

        for(int i=0; i<testCase; i++){
            if(arr[i] >= 4 && arr[i] % 2 == 0){
                System.out.println("YES");
            }else{
                if(millerRabinTest(arr[i] - 2)){
                    System.out.println("YES");
                    continue;
                }
                boolean result = false;
                for(int j=3; j <= arr[i]/2; j += 2){
                    if(millerRabinTest(j) && millerRabinTest(arr[i] - j)){
                        System.out.println("YES");
                        result = true;
                        break;
                    }
                }
                if(!result){
                    System.out.println("NO");
                }
            }
        }


    }


    public static boolean millerRabinTest(long num){

        // 밀러-라빈 소수 판별법
        // n 이 소수라면 n-1 = 2^s * d 이라 할때 (단, d는 홀수) (n-1은 무조건 짝수이므로 이렇게 표현 가능)
        // 페르마의 소정리를 이용하여 아래 두 가지 조건 중 하나를 만족하는 것을 볼 수 있다.
        // 1. a^d mod n = 1  (a^(n-1) mod n = 1 by 페르마의 소정리)
        // 2. a^(2^r * d) mod n = -1 (-> 제곱해나가는 것임)
        //  ㄴ (왜냐하면 1번이 성립하지 않을경우 n이 소수이려면 순환성을 가져야 하므로
        //     mod 값이 -1 인 경우가 한 번이라도 나와야 mod 값이 1인 경우가 바로 다음 나오게 된다.
        //    ㄴ 다른 말로하면 1을 성립하지 않는데, mod 값이 -1이 먼저 나오지 않고 1이 먼저 나오게 된다면
        //      그것은 n이 소수가 아니라는 뜻이다.
        //     이것은 페르마의 소정리에 따라서 n이 소수라면 a^(2^s * d) mod = 1을 언젠가 만족해야하고,
        //     또한 소수의 순환성에 따른 도출 방법이다.

        if(num == 2 || num == 3){
            return true;
        }
        else if(num % 2 == 0 || num < 2){
            return false;
        }

        long d = num-1;
        int s = 0;
        while(d % 2 == 0){
            d /= 2;
            s++;
        }

        Random ran = new Random();
        // 10회 반복하여 테스트
        for(int i=0; i<10; i++){
           long a = 2 + Math.abs(ran.nextLong() % (num - 3));
           long x = modPow(a,d,num);

           if(x == 1 || x == num-1){
                continue;
           }

           boolean isComposite = true;
           for(int r = 1; r < s; r++){
               x = modPow(x, 2,num);
               if(x == num-1){
                   isComposite = false;
                   break;
               }
           }
           if(isComposite) return false;
           // ㄴisComposite가 true이면 더 이상 검사 필요없이 소수가 아니라는 false return

        }
        return true;

    }

    public static long modPow(long a, long b, long n){
        long result = 1;
        a = a % n;
        while(b > 0){
            if((b % 2) == 1){
                result = (result * a) % n;
            }
            b/= 2;
            a = (a * a) % n;
        }
        return result;
    }


}
