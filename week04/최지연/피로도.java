import java.util.*;

class Solution {
    static int n,answer;
    static Node[] node;
    static boolean visited[];
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        n= dungeons.length;
        node=new Node[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            node[i]=new Node(dungeons[i][0],dungeons[i][1]);
        }
        Arrays.sort(node);
        dfs(k,0);        
        return answer;
    }
    
    public void dfs(int k,int cnt){
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(k>=node[i].min_somo){
                    visited[i]=true;
                    dfs(k-node[i].minus_somo,cnt+1);
                    visited[i]=false;
                }
            }
        }
        
        if(answer<cnt) answer=cnt;
    }
    
    class Node implements Comparable<Node>{
        int min_somo;
        int minus_somo;
        
        public Node(int min_somo,int minus_somo){
            this.min_somo=min_somo;
            this.minus_somo=minus_somo;
        }
        
        @Override
        public int compareTo(Node n){
            if(this.min_somo==n.min_somo) return this.minus_somo-n.minus_somo;
            return n.min_somo-this.min_somo;
        }
    }
}