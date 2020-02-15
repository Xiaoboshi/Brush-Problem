class Solution {
    public int maxSubArray(int[] nums) {
        int [] maxnum = new int[nums.length];
        int [] a = new int[nums.length];
        a[0] = nums[0];
        maxnum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            a[i] = Math.max(nums[i], a[i - 1] + nums[i]);
            maxnum[i] = Math.max(maxnum[i - 1], a[i]);
        }
        return maxnum[nums.length - 1];
    }
}
