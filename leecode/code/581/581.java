class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] record = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            record[i] = nums[i];
        }
        Arrays.sort(record);
        while (left < nums.length && nums[left] == record[left]) {
            left++;
        }
        while (right >= left && nums[right] == record[right]) {
                right--;
        }
        return right - left + 1;
    }
}