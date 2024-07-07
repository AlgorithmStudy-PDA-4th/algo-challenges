import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 노드 개수
        M = Integer.parseInt(br.readLine()); // 간선 개수
        graph = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 시작점 0으로 입력
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int cur = n.end;

            if (!visited[cur]) {
                visited[cur] = true;
                for (Node neighbor : graph.get(cur)) { // 인접 노드들 확인
                    // 방문한적이 없고, 새로운 경로가 더 짧은 경우 갱신
                    if (!visited[neighbor.end] && dist[neighbor.end] > dist[cur] + neighbor.cost) {
                        dist[neighbor.end] = dist[cur] + neighbor.cost; // 거리 갱신
                        pq.add(new Node(neighbor.end, dist[neighbor.end])); //가장 비용이 적은 노드 선택 이유 => 해당 노드를 거쳐 가는 경우를 고려하기 때문
                    }
                }
            }
        }
        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

