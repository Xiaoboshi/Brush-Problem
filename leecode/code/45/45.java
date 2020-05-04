class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxp = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxp = Math.max(maxp, i + nums[i]);
            if (i == end) {
                step++;
                end = maxp;
            }
        }
        return step;
    }
}