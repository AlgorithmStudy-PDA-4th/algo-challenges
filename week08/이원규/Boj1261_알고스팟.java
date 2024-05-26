import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m]; //가로m 세로n
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int res = bfs(0, 0);

        System.out.println(res);
    }

    private static int bfs(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, y, 0));
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;

            if (cx == n - 1 && cy == m - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isInRange(nx, ny) && !visit[nx][ny]) {
                    if (arr[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        queue.add(new Node(nx, ny, cur.cnt));
                    } else if (arr[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        queue.add(new Node(nx, ny, cur.cnt + 1));
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

}

class Node implements Comparable<Node> {
    int x, y, cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}