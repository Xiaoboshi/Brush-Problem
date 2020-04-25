class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 1;
        int right = nums.length - 2;

        while (right >= 0 && nums[right + 1] <= nums[right]) {
            right--;
        }

        if (right >= 0) {
            while (left >= 0 && nums[left] <= nums[right]) {
                left--;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        
        int start = right + 1;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}