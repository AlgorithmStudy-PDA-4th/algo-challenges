import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        for (int w : works) {
            queue.add(w);
        }

        while (n > 0) {
            int cur = queue.poll();
            if (cur == 0) break;
            cur -= 1;
            queue.add(cur);
            n--;
        }

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            answer += Math.pow(tmp, 2);
        }

        return answer;
    }
}