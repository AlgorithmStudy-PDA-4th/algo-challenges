import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // 3kg, 5kg
        int[] dp = new int[n + 2];

        Arrays.fill(dp, 100000);

        if (n >= 3)
            dp[3] = 1;
        if (n >= 5)
            dp[5] = 1;

        for (int i = 6; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        if (dp[n] >= 100000)
            System.out.println(-1);
        else
            System.out.println(dp[n]);
    }

}
/**
 * 처음에는 배열을 큰값으로 안채우고 실행해서 틀림
 * 두번째는 Integer의 Max 값으로 채웠더니, 음수값이 나옴
 */
