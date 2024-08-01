#include <string>
#include <vector>
#include <queue>
#include <set>
#include <iostream>

using namespace std;

bool isvisit[500][500];
int mount[500];
int n, m, maxi;

int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

void bfs(vector<vector<int>> &land, int i, int j) {
    isvisit[i][j] = 1;
    int left = j, right = j;
    int size = 1;
    queue<pair<int, int>> q;
    q.push({i,j});
    while(!q.empty()) {
        pair<int, int> tmp = q.front();
        q.pop();
        for(int k=0;k<4;k++) {
            int x2 = tmp.first + dx[k];
            int y2 = tmp.second + dy[k];
            if(x2>=0 && x2<n && y2>=0 && y2<m) {
                if(land[x2][y2]==1 && !isvisit[x2][y2]) {
                    size++;
                    isvisit[x2][y2] = 1;
                    if(y2<left) left = y2;
                    else if(y2>right) right = y2;
                    q.push({x2,y2});
                }
            }
        }
    }
    for(int k=left;k<=right;k++) {
        mount[k] += size;
    }
}



int solution(vector<vector<int>> land) {
    n = land.size();
    m = land[0].size();
    
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(land[i][j]==1 && !isvisit[i][j]) {
                bfs(land, i, j);
            }
        }
    }
    for(int i=0;i<m;i++) {
        if(mount[i]>maxi) maxi = mount[i];
    }
    return maxi;
}
