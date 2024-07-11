import java.util.*;

class Solution {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int xLen = 0;
    static int yLen = 0;
    static char[][] arr;

    public static int solution(String[] maps) {
        xLen = maps.length;
        yLen = maps[0].length();
        arr = new char[xLen][yLen];
        int sx = 0, sy = 0, lx = 0, ly = 0;
        // maps는 5개의 문자, S:시작 E:출구 L:레버 O:통로 X:벽
        for (int i = 0; i < xLen; i++) {
            String str = maps[i];
            for (int j = 0; j < yLen; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (arr[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }

            }
        }
        int answer = bfs(sx, sy, 'L');
        int answer2 = bfs(lx, ly, 'E');
        if (answer == -1 || answer2 == -1) {
            return -1;
        } else
            return answer + answer2;
    }

    static int bfs(int x, int y, char target) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        boolean[][] visited = new boolean[xLen][yLen];

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cnt = cur.count;
            visited[cx][cy] = true;

            if (arr[cx][cy] == target) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny]) {
                    if (arr[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, cnt + 1));
                    }
                }
            }

        }
        return -1;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < xLen && y < yLen;
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}