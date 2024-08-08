days = int(input())
time = [0] * days
pay = [0] * days
for i in range(days):
    time[i], pay[i] = map(int, input().split())

dp = [0] * (days + 1)

for i in range(days - 1, -1, -1):
    if i + time[i] <= days:
        dp[i] = max(dp[i + 1], pay[i] + dp[i + time[i]])
    else:
        dp[i] = dp[i + 1]

max_money = dp[0]

print(max_money)