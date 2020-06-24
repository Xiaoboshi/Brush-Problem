class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 2)
            return 0;
        
        if (nums.length == 3)
            return nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        int minsum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - minsum) > Math.abs(target - sum))
                    minsum = sum;
                if (sum < target) {
                    left++;
                } else if (sum == target){
                    return sum;
                } else {
                    right--;
                }
            }
        }
        return minsum;
    }
}