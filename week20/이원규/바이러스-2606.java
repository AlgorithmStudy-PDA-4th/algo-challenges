import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes.get(s).add(e);
            nodes.get(e).add(s);
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int s = q.poll();
            for (int i = 0; i < nodes.get(s).size(); i++) {
                int e = nodes.get(s).get(i);
                if (!visited[e]) {
                    visited[e] = true;
                    q.add(e);
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

/**
 * 컴퓨터는 100이하 양수
 * 무방향 그래프를 구현하고 값 입력 받은 뒤
 * bfs를 통해 계산하고 출력
 */