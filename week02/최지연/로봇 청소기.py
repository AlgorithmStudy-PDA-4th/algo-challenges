from collections import deque

n,m= map(int,input().split())
r,c,d=map(int,input().split())
room=[]
for _ in range(n):
    room.append(list(map(int,input().split())))

dx=[-1,0,1,0]
dy=[0,1,0,-1]

answer=1
room[r][c]=2
q=deque([(r,c,d)])

while q:
    x,y,d=q.popleft()

    if room[x][y]==0:
        room[x][y]=2
        answer+=1
        q.append((x,y,d))
        continue

    flag=False
    for i in range(d-1,d-5,-1):
        # 이방법 말고 반시계 방향으로 돌릴때는 d=(d+3)%4 이 방법을 사용하자
        tmp= i if i>=0 else i+4
        nx=x+dx[tmp%4]
        ny=y+dy[tmp%4]

        if 0<=nx<n and 0<=ny<m:
            if room[nx][ny]==0:
                answer+=1
                room[nx][ny]=2
                q.append((nx,ny,tmp))
                flag=True
                break
    if flag:
        continue

    if room[x-dx[d]][y-dy[d]]==1:
        break
    else:
        q.append((x-dx[d],y-dy[d],d))
print(answer)