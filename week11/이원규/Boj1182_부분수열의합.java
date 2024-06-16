import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0) System.out.println(answer - 1); //s=0일때 공집합 제외
        else System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) answer++;
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

}

