import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[47];
        for (int i = 1; i < 46; i++) {
            arr[i] = i * (i + 1) / 2;
        }
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean flag = false;
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    for (int l = 1; l < 45; l++) {
                        if (arr[j] + arr[k] + arr[l] == num) {
                            flag = true;
                        }
                    }
                }
            }
            if (flag) System.out.println(1);
            else System.out.println(0);
        }
    }
}
