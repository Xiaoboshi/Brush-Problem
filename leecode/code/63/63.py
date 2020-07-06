class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        r = len(obstacleGrid)
        if r == 0:
            return 0
        c = len(obstacleGrid[0])
        dp = [0] * (c)
        if obstacleGrid[0][0] == 1:
            return 0
        else:
            dp[0] = 1


        for i in range(0, r):
            for j in range(0, c):
                if obstacleGrid[i][j] == 1:
                    dp[j] = 0
                    continue
                if j > 0 and obstacleGrid[i][j] == 0:
                    dp[j] += dp[j - 1]


        return dp[c - 1]