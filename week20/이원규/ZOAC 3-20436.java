import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Character, Node> left = new HashMap<>();
    static HashMap<Character, Node> right = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = 0;
        Node curLeft, curRight;
        dataInit();

        // 엄지, 검지 최초 위치
        String str = br.readLine();
        curLeft = left.get(str.charAt(0));
        curRight = right.get(str.charAt(2));

        // 문자열
        String target = br.readLine();
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            if (left.containsKey(c)) {
                Node tmpLeft = left.get(c);
                num += Math.abs(curLeft.x - tmpLeft.x) + Math.abs(curLeft.y - tmpLeft.y) + 1;
                curLeft = tmpLeft;
            } else if (right.containsKey(c)) {
                Node tmpRight = right.get(c);
                num += Math.abs(curRight.x - tmpRight.x) + Math.abs(curRight.y - tmpRight.y) + 1;
                curRight = tmpRight;
            }
        }
        System.out.println(num);
    }

    private static void dataInit() {
        left.put('q', new Node(1, 1));
        left.put('w', new Node(1, 2));
        left.put('e', new Node(1, 3));
        left.put('r', new Node(1, 4));
        left.put('t', new Node(1, 5));
        left.put('a', new Node(2, 1));
        left.put('s', new Node(2, 2));
        left.put('d', new Node(2, 3));
        left.put('f', new Node(2, 4));
        left.put('g', new Node(2, 5));
        left.put('z', new Node(3, 1));
        left.put('x', new Node(3, 2));
        left.put('c', new Node(3, 3));
        left.put('v', new Node(3, 4));

        right.put('y', new Node(1, 6));
        right.put('u', new Node(1, 7));
        right.put('i', new Node(1, 8));
        right.put('o', new Node(1, 9));
        right.put('p', new Node(1, 10));
        right.put('h', new Node(2, 6));
        right.put('j', new Node(2, 7));
        right.put('k', new Node(2, 8));
        right.put('l', new Node(2, 9));
        right.put('b', new Node(3, 5));
        right.put('n', new Node(3, 6));
        right.put('m', new Node(3, 7));
    }

}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 한글 자음 쪽 자판은 왼손, 모음 쪽 자판은 오른손
 * a의 좌표가 (x1, y1)이고, b의 좌표가 (x2, y2)
 * a에 위치한 성우의 손가락이 b로 이동하는 데에는 a와 b의 택시 거리
 * |x1-x2|+|y1-y2| 만큼의 시간
 * 생각
 * 각 자판들의 절대적인 좌표값을 다 지정해주면 되지 않을까?
 */