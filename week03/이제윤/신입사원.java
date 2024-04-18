import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 신입사원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        int answer = 1;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int recruits = Integer.parseInt(br.readLine());
            int[][] rank = new int[recruits][2];


            for (int j = 0; j < recruits; j++){
                String[] arr = br.readLine().split(" ");
                rank[j][0] = Integer.parseInt(arr[0]);
                rank[j][1] = Integer.parseInt(arr[1]);
            }

            Arrays.sort(rank, (o1,o2) ->{
                return o1[0] - o2[0];
            });
            answer = 1;
            int min = rank[0][1];

            for (int j = 1; j <recruits ; j++) {

                if (rank[j][1] < min){
                    answer++;
                    min = Math.min(min, rank[j][1]);
                }

            }
            System.out.println(answer);

        }

    }
}
