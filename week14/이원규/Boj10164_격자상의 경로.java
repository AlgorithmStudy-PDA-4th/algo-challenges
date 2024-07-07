import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int K = Integer.parseInt(st.nextToken()); // 경유지
        int[][] dp = new int[N][M];
        int sum = 0;

        // (0,0) -> k -> (N,M)
        if (K == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[N - 1][M - 1]);
        } else {
            int kx = (K - 1) / M;
            int ky = (K - 1) % M;

            for (int i = 0; i <= kx; i++) {
                for (int j = 0; j <= ky; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            sum = dp[kx][ky];

            for (int i = kx; i < N; i++) {
                for (int j = ky; j < M; j++) {
                    if (i == kx || j == ky) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            sum *= dp[N - 1][M - 1];
            System.out.println(sum);
        }
    }

}