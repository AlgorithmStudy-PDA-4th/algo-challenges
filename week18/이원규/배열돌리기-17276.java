import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr, tmp;
    static int STANDARD_DEGREE = 45;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 각도
            arr = new int[n][n];
            tmp = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    tmp[j][k] = arr[j][k];
                }
            }
            // 배열 회전
            if (d < 0) { // 오른쪽 회전만 구현하려고 사용.
                d += 360;
            }
            d /= STANDARD_DEGREE; // 회전 횟수
            while (d-- > 0) {
                tiltArr();
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(arr[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void tiltArr() {
        for (int i = 0; i < n; i++) {
            tmp[i][n / 2] = arr[i][i];
            tmp[i][i] = arr[n / 2][i];
            tmp[n / 2][i] = arr[n - i - 1][i];
            tmp[n - i - 1][i] = arr[n - i - 1][n / 2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }
}

/**
 * 1 <= n < 500
 * d는 양수일떄 우회전 음수일떄 좌회전
 * 음수일때는 +360해서 함수를 하나만 사용하도록한다.
 */