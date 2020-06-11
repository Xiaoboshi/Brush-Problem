class Solution {
    public int romanToInt(String s) {
        int[] rec = {1, 10, 100, 1000};
        String[] recs = {"I", "X", "C", "M"};


        int[] recc = {5, 50, 500};
        String[] reccs = {"V", "L", "D"};


        int[] ref = {4, 9, 40, 90, 400, 900};
        String[] refs = {"IV", "IX", "XL", "XC", "CD", "CM"};


        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < rec.length; i++)
            map.put(recs[i], rec[i]);
        
        Map<String, Integer> mapf = new HashMap();
        for (int i = 0; i < recc.length; i++)
            mapf.put(reccs[i], recc[i]);


        Map<String, Integer> maps = new HashMap();
        for (int i = 0; i < ref.length; i++)
            maps.put(refs[i], ref[i]);


        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            temp = temp + s.charAt(i);
            if (map.containsKey(temp)) {
                int k = map.get(temp);
                if (i + 1 < s.length()) {
                    temp = temp + s.charAt(i + 1);
                    if (maps.containsKey(temp)) {
                        res += maps.get(temp);
                        i++;
                    } else {
                        res += k;
                    }
                } else {
                    res += k;
                }
            } else {
                res += mapf.get(temp);
            }
        }
        return res;
    }
}