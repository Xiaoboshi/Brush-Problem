// 时间复杂度过高
class Solution {
    public String longestPrefix(String s) {
        int size = s.length(); 
        String prefix = s;
        String suffix = s;
        for (int i = size - 1; i > 0; i--) {
            prefix = prefix.substring(0, prefix.length() - 1);
            suffix = suffix.substring(1, suffix.length());
            if (prefix.equals(suffix)) {
                return prefix;
            }
        }

        return "";
    }
}
