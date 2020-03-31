class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int temp = nums[0];
        int temp2 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int mm = Math.max(temp * nums[i], temp2 * nums[i]);
            int kk = Math.min(temp * nums[i], temp2 * nums[i]);
            temp = Math.max(nums[i], mm);
            temp2 = Math.min(nums[i], kk);
            max = Math.max(max, temp);
            min = Math.min(min, temp2);
        }
        return max;
    }
}
