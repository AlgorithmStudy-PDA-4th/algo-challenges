import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 폴더의 총 개수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(combination(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    private static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        if (dp[n][r] > 0) return dp[n][r];

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

}
/**
 * 0 < N ≤ M < 30
 * 왼족에 N개 사이트 오른쪽에 M개 사이트 연결
 * 조합. mCn이 정답
 * ex) 29_C_13 -> 67863915
 * nCr = n-1Cr-1 + n-1Cr
 */