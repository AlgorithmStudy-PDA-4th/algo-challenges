import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            } else {
                n -= 2;
                cnt++;
            }

            if (n < 0) {
                cnt = -1;
            }
        }
        System.out.println(cnt);
    }
}