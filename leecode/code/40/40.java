class Solution {
    List<List<Integer>> res;
    Set<List<Integer>> rec;
    public void dfs(int[] candidates, int target, int ind, int sum, List<Integer> l) {
        if (ind >= candidates.length) {
            return;
        }
        if (sum == target) {
            List<Integer> tmp = new ArrayList(l);
            rec.add(tmp);
            return;
        }
        if (sum > target) {
            return;
        }
        
        for (int i = ind + 1; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                l.add(candidates[i]);
                dfs(candidates, target, i, sum + candidates[i], l);
                l.remove(l.size() - 1);
            } else {
                break;
            }
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList();
        rec = new HashSet();
        Arrays.sort(candidates);
        List<Integer> l = new ArrayList();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                l.add(candidates[i]);
                dfs(candidates, target, i, candidates[i], l);
                l.remove(l.size() - 1);
            } else {
                break;
            }
        }
        Iterator<List<Integer>> iterator = rec.iterator();
        while (iterator.hasNext()){
            List<Integer> tmp = new ArrayList(iterator.next());
            res.add(tmp);
        }
        return res;
    }
}