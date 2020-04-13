class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (a.containsKey(nums[i])) {
                a.put(nums[i], a.get(nums[i]) + 1);
            } else {
                a.put(nums[i], 1);
            }
        }

        for(Object key: a.keySet()) {
            if(a.get(key).equals(1)) {
                return (int)key;
            }
        }
        return 0;
    }
}
