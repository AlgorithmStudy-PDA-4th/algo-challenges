import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stdCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < stdCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 남자 1 여자 2
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) { //남학생
                for (int j = 0; j < n; j++) {
                    if ((j + 1) % number == 0) {
                        arr[j] = arr[j] == 0 ? 1 : 0;
                    }
                }
            } else { // 여학생
                arr[number - 1] = arr[number - 1] == 0 ? 1 : 0;
                for (int j = 1; j < n / 2; j++) {
                    if (number - 1 + j >= n || number - 1 - j < 0) // 범위 넘어가면 break
                        break;
                    if (arr[number - 1 - j] == arr[number - 1 + j]) {
                        arr[number - 1 - j] = arr[number - 1 - j] == 0 ? 1 : 0;
                        arr[number - 1 + j] = arr[number - 1 + j] == 0 ? 1 : 0;
                    } else break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

/**
 * 남학생은 숫자의 배수 스위치 변경
 * 여학생은 숫가기준 대칭인경우 변경
 */