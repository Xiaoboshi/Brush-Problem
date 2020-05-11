class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], 
                map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        int index = 0;
        for(int x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                index = x;
            }
        }
        return index;
    }
}