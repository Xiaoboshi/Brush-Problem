class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wl = 0;
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            wl += words[i].length();
        }
        List<Integer> res = new ArrayList();
        if (words.length == 0 || s.length() == 0 || wl > s.length()) {
            return res;
        }
        
        int one = words[0].length();
        for (int i = 0; i < one; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> tmap = new HashMap();
            while (right + one <= s.length()) {
                String ts = s.substring(right, right + one);
                right += one;
                if (!map.containsKey(ts)) {
                    tmap.clear();
                    left = right;
                    count = 0;
                } else {
                    tmap.put(ts, tmap.getOrDefault(ts, 0) + 1);
                    count++;
                    while (tmap.getOrDefault(ts, 0) > map.get(ts)) {
                        String ws = s.substring(left, left + one);
                        count--;
                        tmap.put(ws, tmap.get(ws) - 1);
                        left += one;
                    }
                }
                if (count == words.length)
                    res.add(left);
            }
        }
        return res;
    }
}