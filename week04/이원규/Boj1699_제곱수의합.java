import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        // dp[1] = 1
        // dp[2] = 1 + 1
        // dp[3] = 1 + 1 +1
        // dp[4] = 1
        // dp[5] = 1 + 1
        // dp[6] = 1 + 1 + 1
        // dp[7] = 1 + 1 + 1 + 1
        // dp[8] = 2
        // dp[9] = 1
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j]) {
                    dp[i] = dp[i - j * j] + 1; //1이 j*j의 개수임.
                }
            }
        }
        System.out.println(dp[n]);
    }
}
