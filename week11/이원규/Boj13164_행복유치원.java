import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 비용 = 조 내부에서 최장신 - 최단신
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(arr[i] - arr[i - 1]);
        }
        Collections.sort(list);
        for (int i = 0; i < n - k; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}

