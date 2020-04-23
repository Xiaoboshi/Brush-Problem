class Solution {
    public String minWindow(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap();
        Map<Character, Integer> record = new HashMap();
        for (int i = 0; i < lent; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            record.put(t.charAt(i), 0);
        }
        int count = lent;
        List< List<Integer>> a = new ArrayList();
        while (right < lens && lent <= lens) {
            // right 动，找到第一个满足条件的子串
            while (count > 0 && right < lens) {
                char temp = s.charAt(right);
                if (map.containsKey(temp)) {
                     if (record.get(temp) < map.get(temp))
                        count--;
                    record.put(temp, record.get(temp) + 1);
                }
                right++;
            }
            if (count != 0) {
                break;
            }
            // left 动，缩短串
            while (left < right) {
                char temp2 = s.charAt(left);
                if (record.containsKey(temp2) && record.get(temp2) > 0) {
                    record.put(temp2, record.get(temp2) - 1);
                    if (record.get(temp2) < map.get(temp2)) {
                        count = 1;
                        break;
                    }
                }
                left++;
            }
            List<Integer> b = new ArrayList();
            b.add(left);
            b.add(right);
            a.add(b);
            left++;
        }

        if (a.size() == 0) {
            return "";
        }

        int minx = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i).get(1) - a.get(i).get(0);
            if (temp >= lent && temp < minx) {
                index = i;
                minx = temp;
            }
        }
        //return String.valueOf(a.get(1).get(1)) + String.valueOf(a.get(1).get(0));
        return s.substring(a.get(index).get(0), a.get(index).get(1));
    }
}