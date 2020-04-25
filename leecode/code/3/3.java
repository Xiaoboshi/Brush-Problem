class Solution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length() && left <= right) {
            String temp = "";
            left = right + 1;
            while (right < s.length()) {
                if (temp.indexOf(s.charAt(right)) == -1) {
                    temp = temp + s.charAt(right);
                    right++;
                } else {
                    break;
                }
            }
            max = Math.max(max, temp.length());
            right = left;
        }

        return max;
    }
}