class Solution {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> a = new ArrayList();
        int left = 0;
        int right = 0;
        int[] record = new int[26];
        int[] windows = new int[26];


        for (char x : p.toCharArray())
            record[x - 'a']++;


        int total = 0;
        while (right < s.length()) {
            char temp = s.charAt(right);
            if (record[temp - 'a'] > 0) {
                windows[temp - 'a']++;
                if (windows[temp - 'a'] <= record[temp - 'a'])
                    total++;
            }


            while (total == p.length()) {
                if (right - left + 1 == p.length()) {
                    a.add(left);
                }
                char temp2 = s.charAt(left);
                if (record[temp2 - 'a'] > 0) {
                    windows[temp2 - 'a']--;
                    if (windows[temp2 - 'a'] < record[temp2 - 'a'])
                        total--;
                }
                left++;
            }
            right++;
        }
        return a;
    }
}