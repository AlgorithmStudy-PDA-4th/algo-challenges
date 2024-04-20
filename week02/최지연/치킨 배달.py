n,m=map(int,input().split())
graph=[]
chickens=[]
homes=[]
for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(n):
        if graph[i][j]==2:
            chickens.append((i,j))
        elif graph[i][j]==1:
            homes.append((i,j))

choice=[]
temp=[()]*m
def comb(cnt,start):
    if cnt==m:
        choice.append(temp.copy())
        return
    
    for i in range(start,len(chickens)):
        temp[cnt]=chickens[i]
        comb(cnt+1,i+1)

comb(0,0)

answer=int(1e9)
for c in choice:
    tmp=0
    for h_x,h_y in homes:
        min_val=int(1e9)
        for i in range(m):
            c_x,c_y=c[i]
            min_val=min(abs(c_x-h_x)+abs(c_y-h_y),min_val)
        tmp+=min_val
    answer=min(tmp,answer)
print(answer)