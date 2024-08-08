import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }
        if (dp[N] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

}
/**
 * 1 <= N <= 1000
 * 턴별로 돌은 1 or 3개 가져감
 * 마지막 돌을 가져가면 승리
 * 상근이 먼저 시작. 이기면 SK 지면 CY
 * 완벽한 게임이란걸 최소값이라고 생각함
 * dp[i] = min(dp[i-3], dp[i-1]) +1
 * dp로 하긴 했는데, 굳이 dp 사용하지 않고,
 * 사실 그냥 홀수면 무조건 상근이가 이김.
 */