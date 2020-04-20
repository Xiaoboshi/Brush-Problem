class Solution {

    public int dp(int[][] str, int[] numx,int left, int right) {
        if (left + 1 == right) return 0;

        if (str[left][right] > 0) return str[left][right];

        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, numx[left] * numx[i] * numx[right] +
                           dp(str, numx, left, i) + dp(str, numx, i, right));
        }
        str[left][right] = ans;
        return ans;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] numx = new int[n];

        int[][] str = new int[n][n];

        for (int i = 0; i < n - 2; i++) {
            numx[i + 1] = nums[i];
        }
        numx[0] = numx[n - 1] = 1;

        return dp(str, numx, 0, n - 1);
    }
}