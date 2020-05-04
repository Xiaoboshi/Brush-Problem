class Solution {
    List<List<Integer>> res;
    public void back(int[] candidates, int target, int index, List<Integer> l, int suml) {
        if (suml == target) {
            List<Integer> k = new ArrayList(l);
            res.add(k);
            return;
        } else if (suml > target){
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                l.add(candidates[i]);
                back(candidates, target, i, l, suml + candidates[i]);
                l.remove(l.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList();
        Arrays.sort(candidates);
        back(candidates, target, 0, new ArrayList(), 0);
        return res;
    }
}