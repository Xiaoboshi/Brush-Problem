class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}