class Solution {
    public int[] productExceptSelf(int[] nums) {
        // dp[i] = dp[0 - i-1] * dp[i+1, ...]
        int[] mul1 = new int[nums.length];
        int[] mul2 = new int[nums.length];
        mul1[0] = 1;
        mul2[nums.length - 1] = 1;


        for (int i = 1; i < nums.length; i++) {
            mul1[i] = mul1[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            mul2[i] = mul2[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            mul1[i] *= mul2[i];
        }
        return mul1;
    }
}