class Solution {
    List<List<Integer>> res;
    public void getsub(int[] nums, int index, List<Integer> a) {
        if (index == nums.length) {
            res.add(new ArrayList(a));
            return;
        }


        for (int i = index; i < nums.length; i++) {
            a.add(nums[i]);
            getsub(nums, i + 1, a);
            a.remove(a.size() - 1);
        }
        res.add(new ArrayList(a));
        
    }


    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList();
        getsub(nums, 0, new ArrayList());
        return res;
    }
}