import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end));
        }

        int cnt = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (room.isEmpty() || cur.start < room.peek()) { // 첫 회의, 사용중
                cnt++;
                room.add(cur.end);
            } else {
                room.poll();
                room.add(cur.end);
            }

        }
        System.out.println(cnt);
    }

}

class Node implements Comparable<Node> {
    int start, end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return this.start - o.start;
    }
}
