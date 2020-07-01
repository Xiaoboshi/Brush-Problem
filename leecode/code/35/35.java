class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return -1;
    }
}