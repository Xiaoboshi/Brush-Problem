class Solution {
    public boolean canPartition(int[] nums) {
        int C = 0;
        for (int i = 0; i < nums.length; i++) {
            C += nums[i];
        }
        if (C % 2 == 1) {
            return false;
        }
        int c = C / 2;
        int[][] bkpk = new int[nums.length + 1][c + 1];


        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (nums[i - 1] <= j) {
                    bkpk[i][j] = Math.max(bkpk[i - 1][j - nums[i - 1]] + nums[i - 1], 
                                    bkpk[i - 1][j]);
                } else {
                    bkpk[i][j] = bkpk[i - 1][j];
                }
            }
        }
        if (bkpk[nums.length][c] == c) {
            return true;
        } else {
            return false;
        }
    }
}