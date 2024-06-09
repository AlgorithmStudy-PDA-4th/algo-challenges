import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int [][] arr=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int rotation=Math.min(n,m)/2;
		int[]dx= {0,1,0,-1};
		int[]dy= {1,0,-1,0};
		for(int r=0;r<R;r++) {
			for(int rt=0;rt<rotation;rt++) {
				int x=rt;
				int y=rt;
				int i=0;
				int tmp=arr[x][y];
				while(i<4) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(nx<rt||nx>=n-rt||ny<rt||ny>=m-rt) {i++; continue;}
					arr[x][y]=arr[nx][ny];
					x=nx; y=ny;
				}
				arr[rt+1][rt]=tmp;
			}
		}
		for(int k=0;k<n;k++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[k][j]+" ");
			}
			System.out.println();
		}
	}

}
