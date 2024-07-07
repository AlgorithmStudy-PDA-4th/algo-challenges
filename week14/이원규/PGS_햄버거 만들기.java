import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 1:빵, 2:야채, 3:고기
        // 1 2 3 1
        Stack<Integer> st = new Stack<>();

        for (int i : ingredient) {
            st.push(i);

            int len = st.size();

            if (len >= 4) {
                if (st.get(len - 4) == 1
                        && st.get(len - 3) == 2
                        && st.get(len - 2) == 3
                        && st.get(len - 1) == 1
                ) {
                    answer++;
                    for (int j = 0; j < 4; j++) {
                        st.pop();
                    }
                }
            }
        }

        return answer;
    }
}