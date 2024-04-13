import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.x != o.x)
                    return this.x - o.x;
                return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }

    static int n;
    static int[][] arr;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        //물고기 m마리와 아기상어 1마리
        int sx = 0, sy = 0;
        int curSize = 2;
        int eatCnt = 0, moveCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sx = i;
                    sy = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[][] visit = new boolean[n][n];

            pq.add(new Node(sx, sy, 0));
            visit[sx][sy] = true;
            boolean isEat = false;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                int x = cur.x;
                int y = cur.y;

                if (arr[x][y] != 0 && arr[x][y] < curSize) { //먹을수 있을 때
                    arr[x][y] = 0;
                    eatCnt++;
                    moveCnt += cur.dist;
                    isEat = true;
                    sx = x;
                    sy = y;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (isInRange(nx, ny) && !visit[nx][ny] && arr[nx][ny] <= curSize) {
                        pq.add(new Node(nx, ny, cur.dist + 1));
                        visit[nx][ny] = true;
                    }
                }
            }

            if (!isEat) break; // 엄마상어 호출
            if (curSize == eatCnt) {
                curSize++;
                eatCnt = 0;
            }
        }
        System.out.println(moveCnt);
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

}
