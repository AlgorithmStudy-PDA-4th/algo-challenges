import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] result;
    static char[][] mine;
    static int[][] tmp;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 좌상 좌 좌하 하 우하 우 우상
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        mine = new char[n][n];
        result = new char[n][n];
        tmp = new int[n][n];
        boolean flag = false;

        // *은 지뢰, 지뢰위치 입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                mine[i][j] = str.charAt(j);
            }
        }

        // *기준으로 더하는 로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mine[i][j] == '*') {
                    addNumber(i, j);
                }
            }
        }

        // 더한 숫자를 문자로 변환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (char) (tmp[i][j] + '0');
            }
        }

        // 열린칸 X 아니면 .으로 바꾸기
        // 열린칸인데 지뢰면 flag를 true
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) != 'x') {
                    result[i][j] = '.';
                } else if (mine[i][j] == '*') {
                    flag = true;
                }
            }
        }

        // 지뢰터지면 모든 지뢰위치 *로 바꾸기
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mine[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }

    private static void addNumber(int x, int y) {
        if (mine[x][y] == '*') {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInRange(nx, ny)) {
                    tmp[nx][ny]++;
                }
            }
        }
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

}

/**
 * n * n 크기 배열을 만들고 값 입력 받음
 * * 이면 주변에 1씩 더해줌
 * 지뢰칸 열면 모든 지뢰 *표시하고 나머지가 다 .으로 해석해서 틀림
 */