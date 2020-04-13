// 时间复杂度过高

class Solution {
    public String longestPrefix(String s) {
        if (s.length() <= 1) {
            return "";
        } else {
            char temp = s.charAt(0);
            String ms = "";
            String maxs = "";
            for (int i = 1; i < s.length(); i++) {
                if (temp != s.charAt(i)) {
                    continue;
                } else {
                    int right = i;
                    int left = 0;
                    ms = "";
                    while (right < s.length()) {
                        if (s.charAt(left) == s.charAt(right)) {
                            ms = ms + s.charAt(left);
                            right++;
                            left++;
                        } else {
                            break;
                        }
                    }
                    if (right == s.length()) {
                        if (ms.length() > maxs.length()) {
                            maxs = ms;
                        }
                    }
                }
            }
            return maxs;
        }
    }
}
