import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Node(x, y));
        }
        Node first = pq.poll();
        int start = first.x;
        int end = first.y;
        int result = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.x > end) {
                result += end - start;
                start = cur.x;
                end = cur.y;
            }

            if (cur.y > end) {
                end = cur.y;
            }
        }
        result += end - start;
        System.out.println(result);
    }
}

class Node implements Comparable<Node> {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
