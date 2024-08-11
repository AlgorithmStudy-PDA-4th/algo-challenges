import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[n]);
    }

}
/**
 * 1 <= n <= 10000
 * 최대한 많은 포두주를 마셔야함.
 * 최대 2잔까지 연속으로 마실수 있다.
 * 1잔 마시기 or 2잔 마시기
 * 1. arr[i] 번째를 스킵 -> dp[i-1]과 같은 값
 * 2. arr[i]를 스킵하지 않은 경우,
 * arr[i]가 1번째 잔인 경우와 2번째 잔이 경우의 최대값
 * 1,2 최대값 비교
 */