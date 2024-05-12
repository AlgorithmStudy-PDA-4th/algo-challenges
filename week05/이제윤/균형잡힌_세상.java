import java.io.*;
import java.util.Stack;

public class 균형잡힌_세상 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = "";

        while(!(string = br.readLine()).equals(".")){
            Stack<Character> stack = new Stack<>();
            String answer = "yes";
            for (int i = 0; i < string.length(); i++) {

                char item = string.charAt(i);
                switch (item) {
                    case '[', '(':
                        stack.push(item);
                        break;
                    case ']':
                        if (!stack.isEmpty()){
                            if(stack.peek() != '['){
                                answer = "no";
                            } else {
                                stack.pop();
                            }
                        }
                        break;
                    case ')':
                        if(!stack.isEmpty()){
                            if(stack.peek() != '('){
                                answer = "no";
                            } else {
                                stack.pop();
                            }
                        }

                        break;
                    default:
                        break;
                }
            }
            if(!stack.isEmpty()){
                answer = "no";
            }
            bw.write(answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
