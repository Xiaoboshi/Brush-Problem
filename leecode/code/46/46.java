class Solution {

    List<List<Integer>> result;
    public void backtr(List<Integer> l, List<Integer> re) {
        if (l.size() == 0) {
            result.add(re);
            return;
        }

        for (int i = 0; i < l.size(); i++) {
            List<Integer> newr = new ArrayList();
            int temp = l.remove(i);
            for(int j = 0; j < re.size(); j++) {
                newr.add(re.get(j));
            }
            newr.add(temp);
            backtr(l, newr);
            l.add(i, temp);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList();
        List<Integer> record = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            record.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> k = new ArrayList();
            k.add(nums[i]);
            int temp = record.remove(i);
            backtr(record, k);
            record.add(i, temp);
        }

        return result;
    }
}