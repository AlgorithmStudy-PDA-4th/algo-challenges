import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<String, Node> folderMap = new HashMap<>(); // 폴더 이름을 키로 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 폴더의 총 개수
        M = Integer.parseInt(st.nextToken()); // 파일의 총 개수

        // map초기화
        Node main = new Node("main", true);
        folderMap.put("main", main);

        // 상위 폴더P / 폴더 or 파일 F / 폴더 여부 C
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();
            String F = st.nextToken();
            int C = Integer.parseInt(st.nextToken()); // 1이면 F가 폴더 0이면 파일

            Node parent = folderMap.get(P);
            if (parent == null) {
                parent = new Node(P, true);
                folderMap.put(P, parent);
            }

            Node child = folderMap.get(F);
            if (child == null) {
                child = new Node(F, C == 1);
            }
            parent.children.add(child);
            if (C == 1) { // F가 폴더라면 폴더 구조에 추가
                folderMap.put(F, child);
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String query = br.readLine();
            printResult(query);
        }

    }

    private static void printResult(String query) {
        String[] tmps = query.split("/");
        Node cur = folderMap.get(tmps[tmps.length - 1]); // 쿼리의 제일 마지막 폴더

        Set<String> fileTypes = new HashSet<>();
        int fileCount = countFiles(cur, fileTypes);

        System.out.println(fileTypes.size() + " " + fileCount);
    }

    private static int countFiles(Node cur, Set<String> fileTypes) {
        int count = 0;
        for (Node child : cur.children) {
            if (child.isFolder) {
                count += countFiles(child, fileTypes);
            } else {
                fileTypes.add(child.name);
                count++;
            }
        }
        return count;
    }
}

class Node {
    String name;
    boolean isFolder; // 폴더 여부
    List<Node> children; // 자식 노드

    public Node(String name, boolean isFolder) {
        this.name = name;
        this.isFolder = isFolder;
        this.children = new ArrayList<>();
    }
}
/**
 * Node클래스 -> 폴더, 파일 나타냄
 * 파일 종류의 개수는 Set으로 중복 처리
 * 런타임에러 나서 null 처리 추가했는데, 틀렸습니다가 됨..
 * child도 null처리 하고 통과
 */