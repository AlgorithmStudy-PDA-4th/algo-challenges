import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr = new int[5][5];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                idx++;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (arr[k][l] == num) {
                            arr[k][l] = 0;
                            bingoCheck();
                            if (cnt >= 3) {
                                System.out.println(idx);
                                return;
                            }
                            cnt = 0;
                        }
                    }
                }
            }
        }

    }

    private static void bingoCheck() {
        //가로
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
            if (count == 5) {
                cnt++;
            }
        }
        //세로
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == 0) {
                    count++;
                }
            }
            if (count == 5) {
                cnt++;
            }
        }

        //대각
        int leftCount = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == 0) {
                leftCount++;
            }
            if (leftCount == 5) {
                cnt++;
            }
        }

        int rightCount = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] == 0) {
                rightCount++;
            }
            if (rightCount == 5) {
                cnt++;
            }
        }
    }

}
/**
 * 빙고판을 입력받고 사회자의 숫자를 부를때마다 빙고 체크
 */