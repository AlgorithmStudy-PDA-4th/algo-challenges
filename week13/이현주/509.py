# LeetCode
# The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
# such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

# F(0) = 0, F(1) = 1
# F(n) = F(n - 1) + F(n - 2), for n > 1.
# Given n, calculate F(n).

import collections

class Solution:

    # 브루트포스 풀이법
    # def fib(self, n: int) -> int:
    #     if n <= 1:
    #         return n
        
    #     return fib(n-1) + fib(n-2)

    # 메모이제이션
    dp = collections.defaultdict(int)

    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        
        if self.dp[n]:
            return self.dp[n]
        
        self.dp[n] = self.dp[n-1] + self.dp[n-2]
        return self.dp[n]