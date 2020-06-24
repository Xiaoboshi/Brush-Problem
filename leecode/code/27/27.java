class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                p++;
            } else {
                nums[i - p] = nums[i];
            }
        }
        return nums.length - p;
    }
}