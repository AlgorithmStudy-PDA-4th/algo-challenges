
import java.util.*;

class Solution {

    static Map<Integer, int[]> nodeMap;

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        nodeMap = new HashMap<>();

        for(int[] edge : edges){
            int giver = edge[0];
            int reciver = edge[1];

            if(!nodeMap.containsKey(giver)){
                nodeMap.put(giver, new int[2]);
            }

            if(!nodeMap.containsKey(reciver)){
                nodeMap.put(reciver, new int[2]);
            }

            nodeMap.get(giver)[0]++;
            nodeMap.get(reciver)[1]++;
        }

        for(int key : nodeMap.keySet()){
            int[] node = nodeMap.get(key);

            if(node[0] >= 2 && node[1] == 0) answer[0] = key;
            else if(node[0] == 0 && node[1] > 0) answer[2]++;
            else if(node[0] >= 2 && node[1] >= 2) answer[3]++;
        }
        answer[1] = nodeMap.get(answer[0])[0] - answer[2] - answer[3];
        return answer;
    }
}
