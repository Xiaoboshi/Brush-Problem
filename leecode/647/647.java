class Solution {

    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < 2 * s.length(); i++) {
            int center = i / 2;
            int left = center - 1 + i % 2;
            int right = center + 1;
            int temp = 0;
            if (i % 2 == 0) {
                temp = 1;
            }
            while(left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    temp++;
                } else {
                    break;
                }
                left--;
                right++;
            }
            result += temp;
        }

        return result;
    }
}
