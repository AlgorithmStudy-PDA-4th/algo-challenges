import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}

/**
 * n의 범위 확인 1 <= n <= 50000
 * 제곱한 값이 n 이하인 경우에만 dp 돌린다
 * n보다 작거나 같은 제곱수가 포함된것이 최소이다.
 * 따라서 제곱수가 포함된 dp중에서 최소값을 구하고 1을 더한다.
 * dp[i] = dp[i- j*j] + dp[j*j]
 * dp[j*j]는 1로 고정된 값이기 때문에 dp[1-j*j]만 비교
 * n이 10이라면 min = dp[10 - 9] = dp[1] = 1
 */