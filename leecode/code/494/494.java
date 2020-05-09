class Solution {


    int count = 0;
    public void dfs(int[] nums, int index, int s, int sumn, int flag) {
        if (index == nums.length && sumn == s) {
            count++;
            return;
        }
        if (index == nums.length) {
            return;
        }
        if (flag == 1) {
            sumn += nums[index];
        } else {
            sumn -= nums[index];
        }
        dfs(nums, index + 1, s, sumn, 1);
        dfs(nums, index + 1, s, sumn, -1);
    }


    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S, 0, -1);
        dfs(nums, 0, S, 0, 1);
        return count / 2;
    }
}