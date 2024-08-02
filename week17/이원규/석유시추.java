import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] isVisited;
    static int[] memo;
    static int n, m;

    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        m = land[0].length; // 가로 길이
        n = land.length; // 세로 길이
        isVisited = new boolean[n][m];
        memo = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //가로 고정하고 세로로 bfs진행
                if (!isVisited[j][i] && land[j][i] == 1) {
                    bfs(j, i, land);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, memo[i]);
        }

        return answer;
    }

    static void bfs(int x, int y, int[][] arr) {
        isVisited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        q.add(new Node(x, y));
        int cnt = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            set.add(cy);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isInRange(nx, ny) && !isVisited[nx][ny] && arr[nx][ny] == 1) {
                    isVisited[nx][ny] = true;
                    cnt++;
                    q.add(new Node(nx, ny));
                }
            }
        }

        for (int cur : set) {
            memo[cur] += cnt;
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * bfs로 구현했는데, 효율성 테스트 실패함
 * 조건문 좀 바꿔보고 하다가 검색해보니
 * set쓰라고 되어있어서 바꿈
 */