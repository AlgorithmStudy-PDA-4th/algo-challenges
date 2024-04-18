import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 팰린드롬_만들기 {

    public static void main(String[] args) throws IOException {
        String answer = "";
        StringBuffer sb = new StringBuffer();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        Map<Character, Integer> alphabetCount = new HashMap<>();

        String str = br.readLine();
        for (Character c : str.toCharArray()){
            alphabetCount.put(c, alphabetCount.getOrDefault(c,0)+1);
        }

        List<Character> keySet = new ArrayList<>(alphabetCount.keySet());
        Collections.sort(keySet);

        int countOne = 0;
        boolean isPalindrome = true;
        String middle = "";
        for (Character c : keySet){
            int count = alphabetCount.get(c);
            if ( count % 2 == 0){
                for (int i = 0; i < count / 2; i++) {
                    sb.append(c);
                }
            } else if(count == 1 || count % 2 == 1){
                countOne++;
                if (countOne > 1){
                    isPalindrome = false;
                    break;
                }
                if(count != 1) {
                    sb.append(String.valueOf(c).repeat(count / 2));
                }
            middle = c.toString();
            }else {
                isPalindrome = false;
                break;
            }

        }
        if (!isPalindrome){
            answer = "I'm Sorry Hansoo";
        } else {
            answer = sb + middle;
            answer += sb.reverse();
        }

        System.out.println(answer);
    }
}
