import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, len;

        public Node(int end, int len) {
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return this.len - o.len;
        }
    }

    static int n, e;
    static ArrayList<ArrayList<Node>> arr;
    static boolean[] visit;
    static int[] dist;
    static int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        dist = new int[n + 1];
        visit = new boolean[n + 1];

        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new Node(b, c));
            arr.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        //반드시 지나야 하는 점
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        //1->v1, v1->v2, v2->n
        int res1 = 0, res2 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    private static int dijkstra(int s, int e) {
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curEnd = curNode.end;

            if (!visit[curEnd]) {
                visit[curEnd] = true;
                for (Node n : arr.get(curEnd)) {
                    if (!visit[n.end] && dist[n.end] > dist[curEnd] + n.len) {
                        dist[n.end] = dist[curEnd] + n.len;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }

            }
        }
        return dist[e];
    }

}
