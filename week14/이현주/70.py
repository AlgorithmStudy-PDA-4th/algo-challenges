# LeetCode
# You are climbing a staircase. It takes n steps to reach the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

import collections

class Solution:
    dp = collections.defaultdict(int)

    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        
        if n == 2:
            return 2
        
        if self.dp[n]:
            return self.dp[n]

        self.dp[n] = self.climbStairs(n-1) + self.climbStairs(n-2)
        return self.dp[n]