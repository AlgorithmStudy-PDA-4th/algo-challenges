import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            int tmp = str.charAt(i - 1) - '0';
            if (tmp >= 1 && tmp <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }
            if (i == 1) continue;

            int prev = str.charAt(i - 2) - '0';
            if (prev == 0) continue;

            int sum = prev * 10 + tmp;

            if (sum >= 10 && sum <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[len]);
    }

}