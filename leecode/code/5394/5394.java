class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap();
        int total = 0;
        int maxl = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i).size();
            maxl = Math.max(maxl, nums.get(i).size());
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (map.containsKey(i + j)) {
                    List<Integer> temp = map.get(i + j);
                    temp.add(0, nums.get(i).get(j));
                    map.put(i + j, temp);
                } else {
                    List<Integer> temp = new ArrayList();
                    temp.add(nums.get(i).get(j));
                    map.put(i + j, temp);
                }
            }
        }
        
        int[] result = new int[total];
        total = 0;
        for (int x = 0; x < 2 * maxl; x++) {
            if (map.containsKey(x)) {
                for (int k = 0; k < map.get(x).size(); k++) {
                    result[total] = map.get(x).get(k);
                    total++;
                }
            }
        }
        return result;
    }
}