//문제
//정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//명령은 총 다섯 가지이다.
//
//        1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
//        2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
//        3: 스택에 들어있는 정수의 개수를 출력한다.
//        4: 스택이 비어있으면 1, 아니면 0을 출력한다.
//        5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
//
//        입력
//        첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
//        둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
//        출력을 요구하는 명령은 하나 이상 주어진다.


import java.io.*;
import java.util.Stack;

public class 스택_2 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int operateNum = Integer.parseInt(br.readLine());
        String[] operates = new String[operateNum];
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < operateNum; i++) {
            operates[i] = br.readLine();
        }

        for (int i = 0; i < operateNum; i++) {
            String[] operate = operates[i].split(" ");
            switch (operate[0]) {
                case "1":
                    stack.push(operate[1]);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    } else {
                        bw.write("-1");
                    }
                    bw.newLine();
                    break;
                case "3":
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                case "4":
                    if (stack.empty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    bw.newLine();
                    break;
                case "5":
                    if (!stack.empty()) {
                        bw.write(stack.peek());
                    } else {
                        bw.write("-1");
                    }
                    bw.newLine();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
