class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int len = favoriteCompanies.size();
        
        int[] record = new int[len];
        Map<Integer, Map<String, Integer>> map = new HashMap();
        
        for (int i = 0; i < len; i++) {
            Map<String, Integer> temp = new HashMap();
            List<String> k = favoriteCompanies.get(i);
            for (int j = 0; j < k.size(); j++) {
                temp.put(k.get(j), 1);
            }
            map.put(i, temp);
        }
        
        for (int i = 0; i < len; i++) {
            Map<String, Integer> temp = map.get(i);
            for (int j = 0; j < i; j++) {
                if (record[j] == 0) {
                    int m = 0;
                    Map<String, Integer> k = map.get(j);
                    if (temp.size() < k.size()) {
                        for (String x : temp.keySet()) {
                            if (!k.containsKey(x)) {
                                m = 1;
                                break;
                            }
                        }
                        if (m == 0) {
                            record[i] = 1;
                        }
                    } else if (temp.size() > k.size()) {
                        for (String x : k.keySet()) {
                            if (!temp.containsKey(x)) {
                                m = 1;
                                break;
                            }
                        }
                        if (m == 0) {
                            record[j] = 1;
                        }
                    }
                }
            }
        }
        List<Integer> nm = new ArrayList();
        for (int i = 0; i < len; i++) {
            if (record[i] == 0) {
                nm.add(i);
            }
        }
        return nm;
    }
}