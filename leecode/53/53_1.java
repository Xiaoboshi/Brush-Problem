class Solution {
    public int crosssum(int [] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }
        int leftsum = nums[mid];
        int rightsum = nums[mid];
        int temp = 0;

        for (int i = mid ; i >= left; i--) {
            temp += nums[i];
            leftsum = Math.max(leftsum, temp);
        }
        temp = 0;
        for (int i = mid; i <= right; i++) {
            temp += nums[i];
            rightsum = Math.max(rightsum, temp);
        }
        return (leftsum + rightsum - nums[mid]);
    }

    public int helper(int [] nums, int left, int right) {
        if (left == right){
            return nums[left];
        }
        
        int mid = (right - left) / 2 + left;
        int leftsum = helper(nums, left, mid);
        int rightsum = helper(nums, mid + 1, right);
        int crosssum = crosssum(nums, left, right, mid);

        return Math.max(leftsum, Math.max(rightsum, crosssum));
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
