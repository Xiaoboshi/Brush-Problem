class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int res = nums.length;
        int sum = 0;
        int flag = 0;


        while (right < nums.length) {
            while (right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }


            while (left < right && sum > s) {
                if (sum - nums[left] < s) {
                    break;
                } else {
                    sum -= nums[left];
                    left++;
                }
            }
            if (sum >= s) {
                flag = 1;
                res = Math.min(res, right - left);
            }
            sum -= nums[left];
            left++;
        }
        if (flag == 0) {
            res = 0;
        }
        return res;
    }
}