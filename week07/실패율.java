import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    double rate;

    public Node(int idx, double rate) {
        this.idx = idx;
        this.rate = rate;
    }

    @Override
    public int compareTo(Node o) {
        if (this.rate > o.rate) return -1;
        else if (this.rate < o.rate) return 1;
        else return 0;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        ArrayList<Node> arr = new ArrayList<>();
        double[] tmp = new double[N + 1];

        for (int i = 1; i <= N; i++) {
            double fail = 0;
            double all = 0;
            for (int j = 0; j < len; j++) {
                if (stages[j] >= i) all++;
                if (stages[j] == i) fail++;
            }

            arr.add(new Node(i, fail / all));
        }
        Collections.sort(arr);
        for (int i = 0; i < N; i++) {
            answer[i] = arr.get(i).idx;
        }

        return answer;
    }
}