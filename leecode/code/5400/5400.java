class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> maps = new HashMap();
        Map<String, Integer> mape = new HashMap();
        for (int i = 0; i < paths.size(); i++) {
            String start = paths.get(i).get(0);
            String end = paths.get(i).get(1);
            maps.put(start, maps.getOrDefault(start, 0) + 1);
            maps.put(end, maps.getOrDefault(end, 0));
            mape.put(start, mape.getOrDefault(start, 0));
            mape.put(end, mape.getOrDefault(end, 0) + 1);
        }
        
        String m = "";
        for (String x : mape.keySet()) {
            if ((mape.get(x) + maps.get(x)) == 1) {
                if (mape.get(x) == 1)
                    m = x;
            }
        }
        return m;
    }
}