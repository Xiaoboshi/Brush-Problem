class Solution {
    public int firstMissingPositive(int[] nums) {
        long max = -1;

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                map.put(nums[i], nums[i]);
                max = Math.max(nums[i], max);
            }
        }
 
        for (int i = 1; i <= max + 3; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }
}