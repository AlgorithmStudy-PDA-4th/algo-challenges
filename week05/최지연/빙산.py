import sys
sys.setrecursionlimit(10**4)

n,m=map(int,input().split())
graph=[]
visited = [[0]*m for _ in range(n)]

for _ in range(n):
    graph.append(list(map(int,input().split())))

dx=[-1,0,1,0]
dy=[0,-1,0,1]

def dfs(x,y):
    visited[x][y]=0

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] != 0:
            dfs(nx,ny)

year=0
while(True):
    visited = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            visited[i][j]=graph[i][j]

    for i in range(n):
        for j in range(m):
            # 빙산이 존재하면 상하좌우 바다 체크 후 변형
            if graph[i][j]!=0:
                for k in range(4):
                    nx=i+dx[k]
                    ny=j+dy[k]

                    if 0<=nx<n and 0<=ny<m and graph[nx][ny]==0:
                        if visited[i][j]>0: visited[i][j]-=1
    year += 1
    for i in range(n):
        for j in range(m):
            graph[i][j] = visited[i][j]

    # 빙산이 두덩어리 이상인지 체크
    cnt=0
    for i in range(n):
        for j in range(m):
            if visited[i][j]!=0:
                dfs(i,j)
                cnt+=1

    if cnt==0:
        year=0
        break
    elif cnt>1:
        break

print(year)