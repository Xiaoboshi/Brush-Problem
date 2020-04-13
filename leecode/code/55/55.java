class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
