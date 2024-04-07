import java.util.*;

class Solution {

    public String solution(String[] survey, int[] choices) {
        Character[] personalityType = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        StringBuffer answer = new StringBuffer();
        Map<Character, Integer> personalityMap = new HashMap<>();
        Map<Integer, Integer> scoreMap = new HashMap<>();
        int[] scores = new int[personalityType.length];

        scoreMap.put(1, 3);
        scoreMap.put(2, 2);
        scoreMap.put(3, 1);
        scoreMap.put(4, 0);
        scoreMap.put(5, 1);
        scoreMap.put(6, 2);
        scoreMap.put(7, 3);

        for(int i = 0; i < personalityType.length; i++){
            personalityMap.put(personalityType[i], i);
        }


        for(int i = 0; i < choices.length; i++){
            String item = survey[i];
            char[] type = item.toCharArray();

            char firstType = type[0];
            char secondType = type[1];
            int choice = choices[i];
            if(choice < 4){
                scores[personalityMap.get(firstType)]
                        += scoreMap.get(choice);
            } else if(choice > 4){
                scores[personalityMap.get(secondType)]
                        += scoreMap.get(choice)  ;
            }
        }


        for(int i = 0; i < scores.length; i +=2){

            int personality1 = scores[i];
            int personality2 = scores[i+1];

            if(personality1 > personality2) answer.append(personalityType[i]);
            else if (personality1 == personality2){
                if(personalityType[i] < personalityType[i+1]){
                    answer.append(personalityType[i]);
                } else{
                    answer.append(personalityType[i+1]);
                }
            } else {
                answer.append(personalityType[i+1]);
            }

        }
        return answer.toString();
    }
}