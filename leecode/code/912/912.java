class Solution {

    public int quicksort(int[] nums, int left, int right) {
        int stan = nums[left];
        while (left < right) {
            while(right >= 0 && left < right && nums[right] >= stan) {
                right--;
            }
            nums[left] = nums[right];
            while(left < nums.length && left < right && nums[left] <= stan) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = stan;
        return left;
    }

    public void helper(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = quicksort(nums, left, right);
        helper(nums, left, mid);
        helper(nums, mid + 1, right);
    }

    public int[] sortArray(int[] nums) {
        int len = nums.length;

        helper(nums, 0, len - 1);
        
        return nums;
    }
}
