class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 1;
        int n = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != n) {
                nums[p++] = nums[i];
                n = nums[i];
            }
        }
        return p;
    }
}