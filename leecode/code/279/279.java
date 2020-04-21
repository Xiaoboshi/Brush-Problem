class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;

        for (int i = 1; i < n + 2; i++) {
            int max = (int)Math.pow(i, 0.5);
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= max; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}