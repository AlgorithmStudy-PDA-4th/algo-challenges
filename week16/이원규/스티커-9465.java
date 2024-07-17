import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        //스티커는 대각선으로만 뗄 수 있음
        // 1 ≤ n ≤ 100,000
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + arr[1][j];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }

    }

}
/**
 * 왼쪽이 비어있거나 왼쪽 대각선을 더하거나
 */