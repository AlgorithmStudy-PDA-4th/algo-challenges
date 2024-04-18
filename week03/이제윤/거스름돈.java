import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        int answer = 0;
        int change = Integer.parseInt(br.readLine());

        int remain = change % 5;
        int share = change / 5;

        answer =  share;

        if (remain % 2 == 0){
           answer = share + remain / 2;
        } else {
            while(true){
                if (share == 0){
                    answer = -1;
                    break;
                }
                int temp = (change-(--share * 5));
                if( temp % 2 == 0){
                    answer = temp / 2 + share;
                    break;
                }
                change -= (--share * 5);

            }
        }

        System.out.println(answer);
    }
}
