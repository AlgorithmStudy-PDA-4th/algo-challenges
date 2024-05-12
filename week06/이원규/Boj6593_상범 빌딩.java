import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static char[][][] arr;
    static int[] dl = {0, 1, 0, -1, 0, 0};
    static int[] dr = {1, 0, -1, 0, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};
    static Node start, end;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //지나갈 수 없는 칸 #
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            arr = new char[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = str.charAt(k);
                        if (arr[i][j][k] == 'S') {
                            start = new Node(i, j, k, 0);
                        } else if (arr[i][j][k] == 'E') {
                            end = new Node(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs();
            if (result == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + result + " minute(s).");
        }
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        visited[start.l][start.r][start.c] = false;
        q.offer(new Node(start.l, start.r, start.c, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.l == end.l && cur.r == end.r && cur.c == end.c) {
                return cur.count;
            }
            for (int i = 0; i < 6; i++) {
                int nl = cur.l + dl[i];
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (!visited[nl][nr][nc] && arr[nl][nr][nc] != '#') {
                        visited[nl][nr][nc] = true;
                        q.offer(new Node(nl, nr, nc, cur.count + 1));
                    }
                }
            }
        }
        return -1;
    }

}

class Node {
    int l;
    int r;
    int c;
    int count;

    public Node(int l, int r, int c, int count) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.count = count;
    }
}