import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int s=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());
		String dna=br.readLine();
		st= new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int g=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		int cnt=0;
		
		HashMap<Character, Integer> partDNA=new HashMap<>();
		partDNA.put('A',0);
		partDNA.put('C',0);
		partDNA.put('G',0);
		partDNA.put('T',0);
		for(int i=0;i<p;i++) {
			partDNA.put(dna.charAt(i),partDNA.get(dna.charAt(i))+1);
		}
		if(partDNA.get('A')>=a&&partDNA.get('C')>=c&&partDNA.get('G')>=g&&partDNA.get('T')>=t) cnt++;
		
		for(int i=0;i<s-p;i++) {
			partDNA.put(dna.charAt(i),partDNA.get(dna.charAt(i))-1); //왼쪽문자 삭제
			partDNA.put(dna.charAt(i+p),partDNA.get(dna.charAt(i+p))+1); //오른쪽문자 추가
			if(partDNA.get('A')>=a&&partDNA.get('C')>=c&&partDNA.get('G')>=g&&partDNA.get('T')>=t) cnt++;
		}
		System.out.println(cnt);
	}

}