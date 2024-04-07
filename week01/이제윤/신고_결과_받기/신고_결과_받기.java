
import java.util.*;


class Solution {

    public int[] solution(String[] id_list, String[] reports, int k) {

        int[] answer = new int[id_list.length];
        Map<String, List<String>> userMap = new HashMap<>();
        Map<String, Integer> mailMap = new HashMap<>();
        for(String name : id_list){
            userMap.put(name, new ArrayList<String>());
            mailMap.put(name, 0);
        }

        for(String reportLine : reports){
            String[] report = reportLine.split(" ");
            String repoter = report[0];
            String repotedPerson = report[1];

            List<String> reportUserList = userMap.get(repotedPerson);

            if(!reportUserList.contains(repoter)){
                reportUserList.add(repoter);
            }
        }


        for(String key : userMap.keySet()){
            List<String> reportUsers = userMap.get(key);
            for(String user : reportUsers){
                int a = reportUsers.size() >= k ? 1 : 0;
                mailMap.put( user, mailMap.get(user) + a) ;
            }

        }

        for(int i = 0; i < id_list.length; i++){
            answer[i] = mailMap.get(id_list[i]);
        }

        return answer;
    }
}
