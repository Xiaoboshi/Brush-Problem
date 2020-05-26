class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList();
        Map<String, Map<String, Integer>> map = new HashMap();
        List<String> veg = new ArrayList();
        List<Integer> tables = new ArrayList();
        for (int i = 0; i < orders.size(); i++) {
            String table = orders.get(i).get(1);
            String cap = orders.get(i).get(2);
            if (!veg.contains(cap))
                veg.add(cap);
            Map<String, Integer> temp;
            if (map.containsKey(table))
                temp = map.get(table);
            else {
                temp = new HashMap();
                tables.add(Integer.valueOf(table));
            }
            
            temp.put(cap, temp.getOrDefault(cap, 0) + 1);
            map.put(table, temp);
        }
        Collections.sort(veg);
        Collections.sort(tables);
        veg.add(0, "Table");
        res.add(veg);
        
        for (int i = 0; i < tables.size(); i++) {
            int table = tables.get(i);
            Map<String, Integer> temp = map.get(String.valueOf(table));
            List<String> rest = new ArrayList();
            rest.add(String.valueOf(table));
            for (int j = 1; j < veg.size(); j++) {
                if (temp.containsKey(veg.get(j))) {
                    rest.add(String.valueOf(temp.get(veg.get(j))));
                } else {
                    rest.add("0");
                }
            }
            res.add(rest);
        }
        
        
        return res;
        
    }
}