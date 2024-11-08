package baekjoon.part02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

// 백준 길라잡이 2-4) 기초수학(2) : 15711번 - 환상의 짝꿍 (진짜 풀이)
public class Num15711 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        long[] arr = new long[testCase];
        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
        }

        sol(arr, testCase);

    }

    public static void sol(long[] arr, int testCase){

        for(int i = 0; i < testCase; i++){
            // arr[i] = 1, 2, 3인경우 두 수로 쪼갤때 1이 무조건 들어가므로 두 소수의 합으로 나타낼 수 없다.
            if(arr[i] < 4){
                System.out.println("NO");
            }
            // *4이상의* 모든 짝수는 두 소수의 합으로 나타낼 수 있다. (by 골드바흐의 추측)
            else if(arr[i] >= 4 && arr[i] % 2 == 0){
                System.out.println("YES");
            }
            // arr[i]가 짝수가 아닌 경우(홀수일때) 중에서도 2와 나머지의 합으로 나타낼때, 나머지 수가 소수인경우
            else if(arr[i] % 2 != 0 && millerRabinTest(arr[i] - 2)){
                System.out.println("YES");
            }
            // 합이 홀수라는 것은 짝수 + 홀수 조합으로 나타낼 수 밖에 없는데,
            // 짝수인 소수는 2밖에 없으므로 2와 수소의 조합인 위의 경우에 해당하지 않으면
            // 해당 조합은 무조건 두 소수의 합으로 표현할 수 없다.
            else if(arr[i] % 2 != 0){
                System.out.println("NO");
            }
        }

    }

    public static boolean millerRabinTest(long n){

        /*
            *** 밀러-로빈 알고리즘을 이용한 소수 판별법 ***

            밀러-로빈 알고리즘은 다소 복잡하고 높은 확률(100%는 아님)로 소수를 검증해준다.
            이 알고리즘은 큰 수의 소수 판별에 대해 사용한다.
            (나머지 범위가 정해져서 여러 소수를 비교해야하는 것에는 *에라토스테네스의 체를 사용해 소수 배열이용, 간단한 것은 일반 소수 판별법 이용)

            n이 소수라고 가정하면,
            n - 1 = 2^(s) * d (단, d는 홀수) 로 표현했을때
            임의의 수 a에 대해 a^(n-1) mod n = 1 을 만족한다.(by 페르마의 소정리)

            하지만 위의 것은 소수를 검증하기 위한 필요충분조건이 아니므로
            조건 테스트 횟수를 늘려서 소수가 아닌 것들을 높은 확률로 걸러 낼 수 있도록 해준다.

            조건 1) a^(d) mod n = 1
            조건 2) a^(2^(r) * d) mod n = n-1 ( = -1)
            * 단, 조건 검증시 2 <= a <= n-2 ( 1과 n-1은 자명하게 조건을 만족하므로 뺀다 ) -> n-1이면 당연히 mod 값이 n-1 나오므로

            조건 1,2 중 하나라도 만족해서 테스트를 여러번 검증하면 된다.
            이때, 1,2 두 조건 모두 동시에 만족하지 못하면 그것은 합성수이다.(소수가 아니다)
        */

        if(n == 2 || n == 3){
            return true;
        }
        else if(n < 2 || n % 2 == 0){
            return false;
        }
        long d = n-1;
        int s = 0;
        while(d % 2 == 0){
            d /= 2;
            s++;
        }

        // 테스트를 10회 진행
        Random random = new Random();
        for(int i=0; i<100; i++){
            long a = 2 + (Math.abs(random.nextLong()) % (n - 3));
            long x = modPow(a, d, n);

            if(x == 1 || x == n -1) continue;

            boolean isComposite = true;
            for(int j=1; j<s; j++){
                x = modPow(x, 2, n);
                if(x == n - 1){
                    isComposite = false;
                    break;
                }
            }
            if(isComposite){
                return false;
            }
        }
        return true;

    }

    public static long modPow(long a, long b, long n){
        long result = 1;
        a = a % n; //
        while(b > 0){
            if((b % 2) == 1){ // b == 1일때 마지막으로 조건문을 통과하게 됨
                result = (result * a) % n;
            }
            b /= 2; // b를 반으로 나누어 a*a 를 만들어서 계산을 보다 효율적으로 처리해줌
            a = (a * a) % n;
        }
        return result;
    }
}
