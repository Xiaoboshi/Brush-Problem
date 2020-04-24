class Solution {

    int count = 0;

    public void sort(int[] nums, int left, int mid, int right) {
        if (left >= right)
            return;

        int startl = left;
        int startr = mid + 1;
        int len = right - left + 1;
        int[] record = new int[len];
        int i = 0;
        while (startl <= mid && startr <= right) {
            if (nums[startl] > nums[startr]) {
                record[i] = nums[startr];               
                startr++;
            } else {
                record[i] = nums[startl];
                count += startr - mid - 1;
                startl++;
            }
            i++;
        }

        while (startl <= mid) {
            record[i] = nums[startl];
            count += startr - mid - 1;
            startl++;
            i++;
        }
        while (startr <= right) {
            record[i] = nums[startr];
            startr++;
            i++;
        }
        for (int j = 0; j < len; j++) {
            nums[left] = record[j];
            left++;
        }
    }

    public void helper(int[] nums, int left, int right) {
        if (left >= right)
            return;
        
        int mid =  (right - left) / 2 + left;
        helper(nums, left, mid);
        helper(nums, mid + 1, right);
        sort(nums, left, mid, right);
    }

    public int reversePairs(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return count;
    }
}