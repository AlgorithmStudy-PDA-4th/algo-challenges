import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());

        // 스택 2개로 커서 위치를 처리
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 초기 문자열을 왼쪽 스택에 넣음
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            switch (tmp.charAt(0)) {
                case 'L':
                    // 커서를 왼쪽으로 이동
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    // 커서를 오른쪽으로 이동
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    // 커서 왼쪽 문자 삭제
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    // 커서 왼쪽에 문자 삽입
                    left.push(tmp.charAt(2));
            }
        }

        // 왼쪽 스택을 모두 오른쪽으로 옮긴다.
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        // LIFO이기 때문에 오른쪽에서 순서대로 pop된 문자들이 문자열이된다.
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }

}

/**
 * 문자열 길이 N, 소문자
 * N <= 100,000
 * M(1 ≤ M ≤ 500,000)
 */