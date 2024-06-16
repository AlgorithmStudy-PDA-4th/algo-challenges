import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] isVisited = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
        } else
            System.out.println(search(N));
    }

    public static int search(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        isVisited[num] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = now - 1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = 2 * now;
                }

                if (next == K) {
                    return isVisited[now];
                }
                if (next >= 0 && next <= 100000 && isVisited[next] == 0) {
                    queue.add(next);
                    isVisited[next] = isVisited[now] + 1;
                }
            }
        }
        return 0;
    }
}
