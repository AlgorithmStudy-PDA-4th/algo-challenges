def tabulation(start, end):

    dp = [[0] * (m+1)]*(n+1)

    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == 1 and j == 1:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

    return dp[n][m]


n, m, o = map(int, input().split())

if o == 0:
    print(tabulation(1, n*m))
else:
    print(tabulation(1,o) * tabulation(o, n*m))