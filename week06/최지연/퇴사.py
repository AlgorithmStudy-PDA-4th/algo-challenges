n=int(input())
t=[]
p=[]
for _ in range(n):
    time,price=map(int,input().split())
    t.append(time)
    p.append(price)

dp=[0]*(n+1)
max_val=0

for i in range(n-1,-1,-1):
    tmp=t[i]+i

    if tmp>n:
        dp[i]=max_val
    else:
        dp[i]=max(p[i]+dp[tmp],max_val)
        max_val=dp[i]

print(max_val)