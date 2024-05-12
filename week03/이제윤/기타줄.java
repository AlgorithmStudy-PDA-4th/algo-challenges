import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 기타줄 {

    public static void main(String[] args) throws IOException {

        int n = 0;
        int m = 0;
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);

        int[] six = new int[m];
        int[] each = new int[m];

        for (int i = 0; i < m; i++) {
            String[] price = br.readLine().split(" ");
            six[i] = Integer.parseInt(price[0]);
            each[i] = Integer.parseInt(price[1]);
        }

        Arrays.sort(six);
        Arrays.sort(each);
        int minSix = six[0];
        int minEach = each[0];

        int minBuySix = n / 6;
        int buyEach = n % 6;

        if ( minSix > minEach * 6){
            answer = n * minEach;
        } else {
            answer = Math.min(minBuySix * minSix + buyEach * minEach, (minBuySix+1) * minSix);
        }

        System.out.println(answer);
    }
}
