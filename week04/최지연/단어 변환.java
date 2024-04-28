import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n=words.length;
        boolean flag=false;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                flag=true;
                break;
            }
        }
        if(!flag) return answer;
        
        Queue<Alpha> q= new LinkedList<>();
        q.add(new Alpha(begin,0));

        while(!q.isEmpty()){
            Alpha now=q.poll();
            
            if(now.str.equals(target)){
                answer=now.num;
                return answer;
            }
            
            for(int i=0; i<n; i++){
                int wordLen=words[i].length();
                int diff=0;
                for(int j=0; j<wordLen; j++){
                    if(words[i].charAt(j)!=now.str.charAt(j)) diff++;
                }
                if(diff==1&&!visited[i]){
                    q.add(new Alpha(words[i],now.num+1));
                    visited[i]=true;
                }
            }
        }
        return answer;
    }
    
    class Alpha{
        String str;
        int num;

        Alpha(String str,int num) {
            this.str=str;
            this.num=num;
        }
        
        public String toString(){
            return str+" "+num;
        }
    }

}