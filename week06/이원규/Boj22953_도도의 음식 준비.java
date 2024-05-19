import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, C;
    static int[] arr;
    static long answer = (long) 1000000 * 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        canCook(0);
        System.out.println(answer);
    }

    private static void canCook(int depth) {
        long result = bSearch(1, (long) 1000000 * 1000000);
        answer = Math.min(answer, result);
        if (depth == C) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > 1) {
                arr[i] -= 1;
                canCook(depth + 1);
                arr[i] += 1;
            }
        }

    }

    private static long bSearch(long left, long right) {
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {
                count += mid / arr[i];
            }
            if (count < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            ans = left;
        }

        return ans;
    }

}

