import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        // 0 1 2 3 4 5 6 7 8 9
        // 1 1 1 1 1 1 1 1 1 1 10
        //10 9 8 7 6 5 4 3 2 1 55
        //55 45 36 28 21 15 10 6 3 1 220
        //220
        for (int i = 1; i < n + 1; i++) {

            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        System.out.println(dp[n][0]);
    }

}
