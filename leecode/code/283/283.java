class Solution {
    public void moveZeroes(int[] nums) {
        Stack<Integer> s = new Stack();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else
                s.push(nums[i]);
        }
        for (int i = nums.length - count - 1; i >= 0; i--) {
            nums[i] = s.pop();
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}