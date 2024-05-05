import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int result = right;
        while (left < right) {
            int mid = (left + right) / 2;
            // 현재 중간값(mid)으로 구간을 나눌 수 있는지 확인
            if (isUnderM(arr, mid)) {
                // 가능하다면 최댓값을 줄여본다 (더 작은 값으로 탐색)
                result = Math.min(result, mid);
                right = mid;
            } else {
                // 불가능하다면 최댓값을 늘려본다 (더 큰 값으로 탐색)
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    // 주어진 값으로 구간을 나눌 수 있는지 판별하는 함수
    private static boolean isUnderM(int[] arr, int mid) {
        int cnt = 1;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
            // 현재 구간의 최댓값과 최솟값의 차이가 mid 초과할 경우 새로운 구간 시작
            if (max - min > mid) {
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }
        return cnt <= m;
    }

}
