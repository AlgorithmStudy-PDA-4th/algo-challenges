n,m=map(int,input().split())
arr=[]
for _ in range(n):
    arr.append(list(map(int,input())))

ans=0
dp=[[0]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if i==0 or j==0:
            dp[i][j]=arr[i][j]
        elif arr[i][j]==1:
            dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
        ans=max(ans,dp[i][j])

print(ans*ans)