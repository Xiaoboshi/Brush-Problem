class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> lister= new ArrayList<Integer>();
        int sum = 0;
        int half = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            half += nums[i];
            lister.add(nums[i]);
            if (half * 2 > sum) {
                break;
            }
        }
        return lister;
    }
}
