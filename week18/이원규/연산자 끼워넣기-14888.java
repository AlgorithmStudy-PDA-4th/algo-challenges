import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] opr = new int[4];
    static int[] arr;
    static int n;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void dfs(int num, int idx) {
        if (idx == n) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opr[i] > 0) {
                opr[i]--;
                switch (i) {
                    case 0:
                        dfs(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / arr[idx], idx + 1);
                        break;
                }
                opr[i]++;
            }
        }
    }

}
