import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        circ(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    private static void circ(int x, int y, int n) {
        if (checkSame(x, y, n)) {
            cnt[arr[x][y] + 1] += 1;
            return;
        }
        int cn = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                circ(x + i * cn, y + j * cn, cn);
            }
        }
    }

    private static boolean checkSame(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[x][y] != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
