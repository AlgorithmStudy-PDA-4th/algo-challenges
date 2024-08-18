import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 스위치 개수

        cir(n, getOdd(n));
        System.out.println(min + " " + max);
    }

    private static int getOdd(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n % 10;
            if ((tmp % 2) == 1) cnt++;
            n /= 10;
        }
        return cnt;
    }

    private static void cir(int n, int sum) {
        // 한자리
        if (n < 10) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        } else if (n < 100) {// 두자리
            int newNumber = (n / 10) + (n % 10);
            cir(newNumber, sum + getOdd(newNumber));
        } else {
            String str = Integer.toString(n);
            int len = str.length();
            for (int i = 0; i <= len - 3; ++i) {
                for (int j = i + 1; j <= len - 2; ++j) {
                    String s1 = str.substring(0, i + 1);
                    String s2 = str.substring(i + 1, j + 1);
                    String s3 = str.substring(j + 1, len);

                    int tmp = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    cir(tmp, sum + getOdd(tmp));
                }
            }
        }
    }
}

/**
 * 1 <= n <= 10^9 -1
 * 1. 입력받은 숫자 중에서 홀수의 개수
 * 2. 수가 한자리 -> 종료
 * 3. 수가 두 자리 -> 2개로 나눠서 합 구하여 새로운 수 생성
 * 4. 세 자리 이상 -> 랜덤으로 3분할, 3개 더한 값 새로 생성
 * <p>
 * 재귀 사용
 */