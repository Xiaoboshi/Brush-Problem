class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while(count <= right) {
            if (nums[count] == 0) {
                if (count != left) {
                    int temp = nums[count];
                    nums[count] = nums[left];
                    nums[left] = temp;
                    left++;
                } else {
                    count++;
                    left++;
                }
            } else if (nums[count] == 2) {
                int temp = nums[count];
                nums[count] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                count++;
            }
        }
    }
}