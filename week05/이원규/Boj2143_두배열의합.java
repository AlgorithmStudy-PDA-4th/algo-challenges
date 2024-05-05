import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        //부분 배열의 합 저장
        int aSize = n * (n + 1) / 2;
        long[] aSum = new long[aSize];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = i; j < n; j++) {
                tmp += A[j];
                aSum[idx++] = tmp;
            }
        }
        int bSize = m * (m + 1) / 2;
        long[] bSum = new long[bSize];
        idx = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = i; j < m; j++) {
                tmp += B[j];
                bSum[idx++] = tmp;
            }
        }
        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long cnt = 0;
        for (int i = 0; i < aSize; ) {
            long tmp = aSum[i];
            long aCnt = upperBound(aSum, tmp) - lowerBound(aSum, tmp);
            long bCnt = upperBound(bSum, t - tmp) - lowerBound(bSum, t - tmp);
            cnt += aCnt * bCnt;
            i += aCnt;
        }

        System.out.println(cnt);
    }

    private static long lowerBound(long[] arr, long tmp) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (tmp <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static long upperBound(long[] arr, long tmp) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (tmp >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
