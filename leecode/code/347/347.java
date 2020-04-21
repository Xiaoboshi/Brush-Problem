class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // init
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, 
                                Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int[] result = new int[k];
        int i = 0;
        for (Map.Entry s : list) {
            if (i < k) {
                result[i] = (int)s.getKey();
                i++;
            } else {
                break;
            }
        }
        return result;
    }
}