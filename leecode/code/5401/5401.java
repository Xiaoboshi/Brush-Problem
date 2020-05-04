class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        while (count < nums.length && nums[count] == 0) {
            count++;
        }
        int i = count;
        int space = 0;
        while (i < nums.length) {
            i++;
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            space = i - count - 1;
            count = i;
            if (space < k) {
                return false;
            }
        }
        return true;
    }
}