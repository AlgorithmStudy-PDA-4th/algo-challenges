import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<>();
        PriorityQueue<Integer> ans = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.add(new Point(s, t));
        }

        ans.add(0);

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (ans.peek() <= cur.s) {
                ans.poll();
            }
            ans.add(cur.t);
        }
        System.out.println(ans.size());
    }

    static class Point implements Comparable<Point> {
        int s, t;

        public Point(int s, int t) {
            this.s = s;
            this.t = t;
        }

        public int compareTo(Point p) {
            if (this.s == p.s)
                return this.t - p.t;
            return this.s - p.s;
        }
    }
}
