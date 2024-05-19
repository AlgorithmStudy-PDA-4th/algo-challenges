import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] note1 = new int[n];
            for (int i = 0; i < n; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (search(note1, tmp)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            System.out.print(sb);
        }
    }

    private static boolean search(int[] note1, int target) {
        int left = 0;
        int right = note1.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (note1[mid] == target) {
                return true;
            } else if (note1[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
