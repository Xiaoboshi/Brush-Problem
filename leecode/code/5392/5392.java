class Solution {
    
    public int search(String s, Character target) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target)
                count++;
        }
        return count;
    }
    
    public int maxScore(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String lefts = s.substring(0, i + 1);
            String rights = s.substring(i + 1, s.length());
            int left0 = search(lefts, '0');
           
            int right1 = search(rights, '1');
            
            result = Math.max(left0 + right1, result);
        }
        return result;
    }
}