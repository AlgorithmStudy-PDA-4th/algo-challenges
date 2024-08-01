def max_sticker_score(test_cases):
    results = []
    for stickers in test_cases:
        n = len(stickers[0])
        if n == 1:
            results.append(max(stickers[0][0], stickers[1][0]))
            continue
        elif n == 2:
            results.append(max(stickers[0][0] + stickers[1][1], stickers[1][0] + stickers[0][1]))
            continue
        
        dp = [[0] * n for _ in range(2)]
        dp[0][0] = stickers[0][0]
        dp[1][0] = stickers[1][0]
        dp[0][1] = stickers[0][1] + stickers[1][0]
        dp[1][1] = stickers[1][1] + stickers[0][0]
        
        for i in range(2, n):
            dp[0][i] = max(dp[1][i-1], dp[1][i-2]) + stickers[0][i]
            dp[1][i] = max(dp[0][i-1], dp[0][i-2]) + stickers[1][i]
        
        results.append(max(dp[0][-1], dp[1][-1]))
    
    return results

tc_num = int(input())
test_cases = []

for _ in range(tc_num):
    n = int(input())
    stickers = []
    for _ in range(2):
        stickers.append(list(map(int, input().split())))
    test_cases.append(stickers)

results = max_sticker_score(test_cases)

for result in results:
    print(result)
