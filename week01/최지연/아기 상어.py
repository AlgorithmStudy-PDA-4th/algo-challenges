from collections import deque
import heapq

n=int(input())
space=[]
fishes=[] # [(거리,x,y,크기)]
shark=[]
time=0
eat=0

for i in range(n):
    space.append(list(map(int,input().split())))
    for j in range(n):
        if space[i][j]==9:
            shark=[2,i,j]

def bfs():
    dx=[-1,0,0,1]
    dy=[0,-1,1,0]
    visited=[[-1]*n for _ in range(n)]
    global time, shark, eat

    q=deque([(shark[1],shark[2])])
    visited[shark[1]][shark[2]]=0

    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<n and 0<=ny<n and visited[nx][ny]==-1:
                if space[nx][ny]>shark[0]:
                    continue

                q.append((nx,ny))
                visited[nx][ny]=visited[x][y]+1

                if 0<space[nx][ny]<shark[0]:
                    # [(거리,x,y,크기)]
                    heapq.heappush(fishes,(visited[nx][ny],nx,ny,space[nx][ny]))

bfs()
while fishes:
    fish=heapq.heappop(fishes)
    if fish[3]<shark[0]:
        eat+=1
        space[fish[1]][fish[2]]=9
        space[shark[1]][shark[2]]=0
        time+=fish[0]
        shark=[shark[0],fish[1],fish[2]]
        if shark[0]==eat:
            shark[0]+=1
            eat=0
        fishes=[]
        bfs()

print(time)