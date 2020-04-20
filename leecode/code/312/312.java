class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] numx = new int[n];
        for (int i = 0; i < n - 2; i++) {
            numx[i + 1] = nums[i];
        }
        numx[0] = numx[n - 1] = 1;

        int[][] dp = new int[n][n];

        for (int left = n - 2; left >= 0; left--) {
            for (int right = left + 2; right < n; right++) {
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], 
                    numx[left] * numx[i] * numx[right] + dp[left][i] + dp[i][right]);
                }
            }
        }

        return dp[0][n - 1];
    }
}