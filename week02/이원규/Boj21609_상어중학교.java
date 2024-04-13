import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, color, blockCnt, rainbowCnt;

        public Node(int x, int y, int color, int blockCnt, int rainbowCnt) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.blockCnt = blockCnt;
            this.rainbowCnt = rainbowCnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.blockCnt != o.blockCnt)
                return o.blockCnt - this.blockCnt;
            if (this.rainbowCnt != o.rainbowCnt)
                return o.rainbowCnt - this.rainbowCnt;
            if (this.x != o.x)
                return o.x - this.x;
            return o.y - this.y;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, ans;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cx = 0, cy = 0;
        // 여러개라면 무지개블록:0 을 많이 포함한 개수
        // 찾은 블록 그룹 제거. B 제곱 만큼 점수 획득
        //중력 작용. 검정블록-1 제외 다 아래행으로 이동
        // 90도 반시계
        //중력
        while (true) {
            // 가장 큰 블록 그룹 찾기
            Node bNode = findGroup();
            if (bNode == null) break;

            // 점수 계산
            ans += bNode.blockCnt * bNode.blockCnt;
            // 블록 제거
            removeBlock(bNode);

            //중력
            gravity();

            //회전
            rotateArr();

            //중력
            gravity();

        }
        System.out.println(ans);
    }

    static void printTest() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateArr() { //90도 반시계 회전
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = arr[j][n - i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }

    private static void gravity() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] == -2 || arr[j][i] == -1) continue;
                moveBlock(j, i);
            }
        }
    }

    private static void moveBlock(int x, int y) {
        int cx = x;
        while (true) {
            cx++;
            if (cx >= n || arr[cx][y] != -2) {
                break;
            }
        }
        cx--;
        if (cx == x) return;
        arr[cx][y] = arr[x][y];
        arr[x][y] = -2;
    }

    private static void removeBlock(Node bNode) {
        int i = bNode.x;
        int j = bNode.y;
        visit = new boolean[n][n];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visit[i][j] = true;
        arr[i][j] = -2;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                //범위안 && 검정블록x && 방문x && 같은블록 && 빈공간x
                if (isInRange(nx, ny) && arr[nx][ny] != -1 && !visit[nx][ny]
                        && arr[nx][ny] != -2) {
                    if (arr[nx][ny] != bNode.color) {
                        if (arr[nx][ny] == 0) {
                            visit[nx][ny] = true;
                            arr[nx][ny] = -2;
                            q.add(new Point(nx, ny));
                        }
                        continue;
                    }
                    visit[nx][ny] = true;
                    arr[nx][ny] = -2;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    private static Node findGroup() {
        visit = new boolean[n][n];
        Node maxNode = new Node(0, 0, -2, -10, -10);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //검정블록x && 방문x && 무지개블록x && 빈칸 -2
                if (arr[i][j] != -1 && !visit[i][j] && arr[i][j] != 0 && arr[i][j] != -2) {
                    //무지개블록방문 초기화 후 탐색
                    resetRainbow();
                    Node curNode = findB(i, j, arr[i][j]);

                    if (curNode != null) {
                        PriorityQueue<Node> pq = new PriorityQueue<>();
                        pq.add(maxNode);
                        pq.add(curNode);
                        maxNode = pq.poll();
                    }
                }
            }
        }
        if (maxNode.color == -2) return null;

        return maxNode;
    }

    private static void resetRainbow() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0)
                    visit[i][j] = false;
            }
        }
    }

    private static Node findB(int i, int j, int color) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visit[i][j] = true;
        int blockCnt = 1;
        int rainbowCnt = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                //범위안 && 검정블록x && 방문x && 같은블록 || 빈공간
                if (isInRange(nx, ny) && arr[nx][ny] != -1 && !visit[nx][ny]
                        && arr[nx][ny] != -2) {
                    if (arr[nx][ny] != color) {
                        if (arr[nx][ny] == 0) {
                            visit[nx][ny] = true;
                            rainbowCnt++;
                            blockCnt++;
                            q.add(new Point(nx, ny));
                        }
                        continue;
                    }
                    visit[nx][ny] = true;
                    blockCnt++;
                    q.add(new Point(nx, ny));
                }
            }
        }
        if (blockCnt < 2) return null;
        else return new Node(i, j, color, blockCnt, rainbowCnt);
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

}
