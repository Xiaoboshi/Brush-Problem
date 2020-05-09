class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        row = len(matrix)
        if row == 0:
            return 0
        col = len(matrix[0])
        dp = [[0]* (col + 1) for _ in range(row + 1)]
        maxp = 0
        for i in range(1, row + 1):
            for j in range(1, col + 1):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
                maxp = max(maxp, dp[i][j])


        return maxp * maxp