class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int count = 0;
        int sing = 0;
        for(Character a : map.keySet()) {
            int temp = map.get(a);
            if (temp >= 2) {
                if (temp % 2 == 0)
                    count += temp;
                else {
                    count += temp - 1;
                    sing += 1;
                }
            } else {
                sing += temp;
            }
        }
        if (sing != 0)
            count++;
        return count;
    }
}
