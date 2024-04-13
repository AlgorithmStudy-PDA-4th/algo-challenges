import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    static int n, m, k;
    static int[][] arr;
    static int[][] recentAttack;
    static boolean[][] isAttacked;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] ddx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] ddy = {1, 0, -1, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        recentAttack = new int[n][m];
        isAttacked = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        //4가지액션 순서대로 수행 k번 반복
        while (k-- > 0) {
            idx++;
            isAttacked = new boolean[n][m];
            //가장 약한 포탑이 공격자. -> N+M 만큼 공격력 증가
            int[] attackTurret = findWeakTurret();
            arr[attackTurret[0]][attackTurret[1]] += n + m;
            isAttacked[attackTurret[0]][attackTurret[1]] = true;
            recentAttack[attackTurret[0]][attackTurret[1]] = idx;

            //자신을 제외한 가장 강한 포탑 공격
            int[] target = findStrongTurret(attackTurret);
            isAttacked[target[0]][target[1]] = true;

            //공격
            if (!laserAttack(attackTurret, target)) {
                bombAttack(attackTurret, target);
            }

            // 포탑 부서짐
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] < 0)
                        arr[i][j] = 0;
                }
            }

            // 포탑 정비
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) continue;
                    if (isAttacked[i][j]) continue;
                    arr[i][j] += 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        System.out.println(max);
    }

    private static void bombAttack(int[] attackTurret, int[] target) {
        arr[target[0]][target[1]] -= arr[attackTurret[0]][attackTurret[1]];
        int power = arr[attackTurret[0]][attackTurret[1]] / 2;
        for (int i = 0; i < 8; i++) {
            int nx = (target[0] + ddx[i] + n) % n;
            int ny = (target[1] + ddy[i] + m) % m;
            if (nx == attackTurret[0] && ny == attackTurret[1]) continue;
            arr[nx][ny] -= power;
            isAttacked[nx][ny] = true;
        }
    }

    private static boolean laserAttack(int[] attackTurret, int[] target) {
        boolean[][] visited = new boolean[n][m];
        Point[][] reverse = new Point[n][m];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(attackTurret[0], attackTurret[1]));
        visited[attackTurret[0]][attackTurret[1]] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = (cur.x + dx[i] + n) % n;
                int ny = (cur.y + dy[i] + m) % m;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) continue;
                reverse[nx][ny] = new Point(cur.x, cur.y);
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }

        if (!visited[target[0]][target[1]]) return false;

        int tx = target[0], ty = target[1];
        while (tx != attackTurret[0] || ty != attackTurret[1]) {
            int power = arr[attackTurret[0]][attackTurret[1]] / 2;
            if (tx == target[0] && ty == target[1]) {
                power = arr[attackTurret[0]][attackTurret[1]];
            }
            arr[tx][ty] -= power;
            isAttacked[tx][ty] = true;
            Point point = reverse[tx][ty];
            tx = point.x;
            ty = point.y;
        }
        return true;
    }

    private static int[] findStrongTurret(int[] att) {
        int rx = 0;
        int ry = 0;
        int maxPower = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 부서진 포탑 제외
                if (arr[i][j] == 0) continue;
                if (i == att[0] && j == att[1]) continue;

                // 가장 큰 수
                if (arr[i][j] > maxPower) {
                    maxPower = arr[i][j];
                    rx = i;
                    ry = j;
                    continue;
                } else if (arr[i][j] < maxPower) continue;

                // 가장 오랜된 공격
                if (recentAttack[i][j] < recentAttack[rx][ry]) {
                    rx = i;
                    ry = j;
                    continue;
                } else if (recentAttack[i][j] > recentAttack[rx][ry]) continue;

                // 행,열 합
                if (i + j < rx + ry) {
                    rx = i;
                    ry = j;
                    continue;
                } else if (i + j > rx + ry) continue;

                if (j < ry) {
                    rx = i;
                    ry = j;
                }
            }
        }
        return new int[]{rx, ry};
    }

    private static int[] findWeakTurret() {
        int rx = 0;
        int ry = 0;
        int minPower = 9999999;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 부서진 포탑 제외
                if (arr[i][j] == 0) continue;

                // 가장 작은 수
                if (arr[i][j] < minPower) {
                    minPower = arr[i][j];
                    rx = i;
                    ry = j;
                    continue;
                } else if (arr[i][j] > minPower) continue;

                // 가장 최근 공격
                if (recentAttack[i][j] > recentAttack[rx][ry]) {
                    rx = i;
                    ry = j;
                    continue;
                } else if (recentAttack[i][j] < recentAttack[rx][ry]) continue;

                // 행,열 합
                if (i + j > rx + ry) {
                    rx = i;
                    ry = j;
                    continue;
                } else if (i + j < rx + ry) continue;

                if (j > ry) {
                    rx = i;
                    ry = j;
                }
            }
        }
        return new int[]{rx, ry};
    }

}
