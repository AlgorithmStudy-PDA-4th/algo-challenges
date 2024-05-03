from collections import deque

n=int(input())
arr=[]
max_val=0
for i in range(n):
    arr.append(list(map(int,input().split())))
    max_val=max(max_val,max(arr[i]))

dx=[-1,0,1,0]
dy=[0,-1,0,1]
def bfs(x,y):
    q=deque([(x,y)])
    visited[x][y]==1

    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<n and 0<=ny<n and visited[nx][ny]==0 and copy_arr[nx][ny]!=0:
                q.append((nx,ny))
                copy_arr[nx][ny]=0
                visited[nx][ny]=1
    return 

def sink(num):
    copy_arr=[x[:] for x in arr]
    for i in range(n):
        for j in range(n):
            if copy_arr[i][j]<=num:
                copy_arr[i][j]=0
    return copy_arr

answer=1
for m in range(1,max_val+1):
    copy_arr=sink(m)
    tmp=0
    visited=[[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if copy_arr[i][j]!=0:
                bfs(i,j)
                tmp+=1
    answer=max(answer,tmp)
print(answer)