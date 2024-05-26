import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dirArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[4][8];

        //n=0, s=1
        for (int i = 0; i < 4; i++) { // 톱니 입력
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; //톱니번호
            int dir = Integer.parseInt(st.nextToken()); //1: 시계 방향, -1:반시계 방향

            dirArr = new int[4];
            dirArr[num] = dir;
            //방향 확인
            checkDir(num);
            //회전
            arrTurn();
        }
        int result = 0;
        if (arr[0][0] == 1) result += 1;
        if (arr[1][0] == 1) result += 2;
        if (arr[2][0] == 1) result += 4;
        if (arr[3][0] == 1) result += 8;
        System.out.println(result);
    }

    private static void arrTurn() {
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            if (dirArr[i] == 1) { //시계
                tmp = arr[i][7];
                for (int j = 7; j > 0; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][0] = tmp;
            }
            if (dirArr[i] == -1) { //반시계
                tmp = arr[i][0];
                for (int j = 0; j < 7; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][7] = tmp;
            }
        }
    }

    private static void checkDir(int num) {
        //왼쪽 확인
        for (int i = num - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) {
                dirArr[i] = -dirArr[i + 1];
            } else {
                break;
            }
        }
        //오른쪽 확인
        for (int i = num + 1; i < 4; i++) {
            if (arr[i][6] != arr[i - 1][2]) {
                dirArr[i] = -dirArr[i - 1];
            } else {
                break;
            }
        }
    }

}
