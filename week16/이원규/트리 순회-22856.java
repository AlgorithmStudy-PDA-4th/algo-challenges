import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static ArrayList<Integer> inOrder;
    static int lastNode;
    static int count, visitCount;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 현재 노드 a
        // 현재 노드의 왼쪽 자식 노드 b
        // 현재 노드의 오른쪽 자식 노드 c
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        inOrder = new ArrayList<>();
        // 중위 순회, 마지막 노드 찾기
        search(1);
        lastNode = inOrder.get(inOrder.size() - 1);
        // 유사 중위 순회
        similarInOrder(1);

    }

    private static void similarInOrder(int n) {
        Node cur = list[n].get(0);
        int left = cur.left;
        int right = cur.right;

        if (left != -1) {
            similarInOrder(left);
            count++;
        }
        if (lastNode == n) {
            System.out.println(count);
            return;
        }
        count++;
        if (right != -1) {
            similarInOrder(right);
            count++;
        }
    }

    private static void search(int n) {
        Node cur = list[n].get(0);
        int left = cur.left;
        int right = cur.right;

        if (left != -1) {
            search(left);
        }
        inOrder.add(n);
        if (right != -1) {
            search(right);
        }
    }
}

class Node {
    int left;
    int right;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
/**
 * 트리를 먼저 구현하고, 값을 입력 받는다.
 * 중위 순회값을 리스트에 저장
 * 마지막 노드값을 구한다.
 * 유사 중위 순회 로직 실행
 */