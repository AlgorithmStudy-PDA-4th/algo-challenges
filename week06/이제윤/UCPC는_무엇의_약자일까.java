import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UCPC는_무엇의_약자일까 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        String givernString = br.readLine();
        char[] UCPC = {'U','C','P','C'};

        int idx = 0;
        for(char c : givernString.toCharArray()){
            if (UCPC[idx] == c){
                idx++;
            }

            if (idx == UCPC.length){
                System.out.println("I love UCPC");
                return;
            }
        }
        System.out.println("I hate UCPC");

    }
}
