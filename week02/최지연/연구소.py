from collections import deque

n,m=map(int,input().split())
lab=[]
cond=[]
for i in range(n):
    lab.append(list(map(int,input().split())))
    for j in range(m):
        if lab[i][j]==0:
            cond.append((i,j))

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(x,y,arr):
    q=deque([(x,y)])
    arr[x][y]=-2

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<n and 0<=ny<m and arr[nx][ny]==0:
                arr[nx][ny]=-2
                q.append((nx,ny))
    return arr

def virus(choice):
    lab_copy=[[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            lab_copy[i][j]=lab[i][j]

    for c in choice:
        x,y=c
        lab_copy[x][y]=1

    for i in range(n):
        for j in range(m):
            if lab_copy[i][j]==2:
                lab_copy=bfs(i,j,lab_copy)

    cnt=0
    for i in range(n):
        for j in range(m):
            if lab_copy[i][j]==0:
                cnt+=1
    return cnt

max_val=-int(1e9)
tmp=[()]*3
def comb(cnt,start):
    global max_val
    if cnt==3:
        #바이러스 퍼트리기
        safe=virus(tmp)
        #비교해서 저장
        max_val=max(max_val,safe)
        return

    for i in range(start,len(cond)):
        tmp[cnt]=cond[i]
        comb(cnt+1,i+1)

comb(0,0)
print(max_val)