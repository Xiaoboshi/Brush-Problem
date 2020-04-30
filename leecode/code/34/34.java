class Solution {

    public int helper(int[] nums, int target, int flag) {
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (flag == 1 && nums[mid] == target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] nul = {-1, -1};
        if (len == 0 || target < nums[0] || target > nums[len - 1]) {
            return nul;
        }

        int left = helper(nums, target, 1);
        if (nums[left] != target) {
            return nul;
        }
        int right = helper(nums, target, 0);
        int[] result = {left, right - 1};
        return result;
    }
}