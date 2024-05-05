import java.util.*;

class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static Queue<int[]> q;
    static int n,m;
    static int[][] visited;
    public int solution(int[][] maps) {
        int answer = -1;
        n=maps.length;
        m=maps[0].length;
        visited=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],-1);
        }
        q=new LinkedList<>();
        
        q.add(new int[]{0,0});
        visited[0][0]=1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(nx>=0&&nx<n&&0<=ny&&ny<m){
                    if(visited[nx][ny]==-1&&maps[nx][ny]==1){
                        visited[nx][ny]=visited[now[0]][now[1]]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        answer=visited[n-1][m-1];
        return answer;
    }
}