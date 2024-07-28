import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][n];
        int[][] arr = new int[n][n];
        int le = dp.length;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curNumber = arr[i][j];
                if (curNumber == 0) break;
                //curNumber만큼 오른쪽 or 아래쪽 이동가능
                //가로 범위 안쪽인 경우
                if (j + curNumber < n) {
                    dp[i][j + curNumber] += dp[i][j];
                }
                //세로 범위 안쪽인 경우
                if (i + curNumber < n) {
                    dp[i + curNumber][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}

/**
 * 크기 n
 * 입력 값은 0 ~ 9
 * 이동은 반드시 오른쪽 or 아래쪽
 * 0이 종착지
 * dp 사이즈 int로 했더니 틀림
 * 경로의 개수는 2^63-1보다 작거나 같다. 라는 조건을 확인 못함
 */