class Solution {


    public int maximalSquare(char[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return 0;
        }
        int row = matrix[0].length;


        int[][] dp = new int[len + 1][row + 1];
        int maxp = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= row; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxp = Math.max(dp[i][j], maxp);
                }
            }
        }
        return maxp * maxp;
    }
}