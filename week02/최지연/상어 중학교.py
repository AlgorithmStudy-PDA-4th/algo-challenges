from collections import deque
import heapq
n,m=map(int,input().split())
graph=[]
for _ in range(n):
    graph.append(list(map(int,input().split())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(i,j,color):
    q=deque([(i,j)])
    visited[i][j]=True
    rainbow=0
    cnt=1
    rainbows=[] #방문체크 해제용

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<n and 0<=ny<n and not visited[nx][ny]:
                if graph[nx][ny]==color:
                    cnt+=1
                    q.append((nx,ny))
                    visited[nx][ny]=True
                elif graph[nx][ny]==0:
                    cnt+=1
                    rainbow+=1
                    q.append((nx,ny))
                    visited[nx][ny]=True
                    rainbows.append((nx,ny))

    #무지개 방무체크 해제
    for x,y in rainbows:
        visited[x][y]=False

    return [cnt,rainbow]

def remove(i,j,color):
    q=deque([(i,j)])
    graph[i][j]=-2

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and graph[nx][ny]!=-2:
                if graph[nx][ny]==color:
                    q.append((nx,ny))
                    graph[nx][ny]=-2
                elif graph[nx][ny]==0:
                    q.append((nx,ny))
                    graph[nx][ny]=-2

def gravity():
    for i in range(n-1,-1,-1):
        for j in range(n-1,-1,-1):
            if graph[i][j]>=0:
                a=i
                while True:
                    if a+1>=n or graph[a+1][j]!=-2:
                        break
                    a+=1
                if i!=a:
                    graph[a][j] = graph[i][j]
                    graph[i][j]=-2

def rotation():
    new=[[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            new[n-j-1][i]=graph[i][j]
    return new

answer=0
while True:
    blocks = []
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j]>0 and not visited[i][j]:
                cnt,rainbow=bfs(i,j,graph[i][j])
                if cnt>1:
                    heapq.heappush(blocks,(-cnt,-rainbow,-i,-j))
    if not blocks:
        break
    cnt,rainbow,i,j=heapq.heappop(blocks)
    cnt=abs(cnt)
    rainbow=abs(rainbow)
    i=abs(i)
    j=abs(j)
    answer+=cnt**2
    remove(i,j,graph[i][j])
    gravity()
    graph=rotation()
    gravity()

print(answer)