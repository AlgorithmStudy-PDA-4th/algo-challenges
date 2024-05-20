import java.util.HashMap;

class Solution {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        int[] tmp = new int[privacies.length];
        HashMap<String, Integer> map = new HashMap<>();

        int day = cirDay(today);

        for (String t : terms) {
            String[] term = t.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            if (cirDay(pri[0]) + (map.get(pri[1]) * 28) <= day) {
                tmp[idx++] = i + 1;
                cnt++;
            }
        }
        idx = 0;
        answer = new int[cnt];
        for (int i : tmp) {
            if(i != 0)
                answer[idx++] = i;
        }

        return answer;
    }

    public static int cirDay(String str) {
        String[] date = str.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}