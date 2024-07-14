#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> v) {
    int answer = 0;
    
    stack<int> s;
    for(int i=0;i<v.size();i++) {
        s.push(v[i]);
        stack<int> tmp;
        if(s.size()>=4) {
            bool flag = 0;
            for(int j=0;j<4;j++) {
                if(j==0 && s.top()==1) {
                    tmp.push(s.top());
                    s.pop();
                }
                else if (j==1 && s.top()==3) {
                    tmp.push(s.top());
                    s.pop();
                }
                else if(j==2 && s.top()==2) {
                    tmp.push(s.top());
                    s.pop();
                }
                else if(j==3 && s.top()==1) {
                    tmp.push(s.top());
                    s.pop();
                }
                else {
                    flag = 1;
                    while(!tmp.empty()) {
                        s.push(tmp.top());
                        tmp.pop();
                    }
                    break;
                }
            }
            if(!flag) answer++;
        }
    }
    return answer;
}
