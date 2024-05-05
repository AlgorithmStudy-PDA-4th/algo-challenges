import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[] = new int[k];
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        long end = arr[k - 1];
        long start = 1;
        long mid = 0;

        while (end >= start) {
            mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < k; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(end);
    }
}
