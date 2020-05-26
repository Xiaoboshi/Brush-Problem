class Solution {
    public int maxVowels(String s, int k) {
        
        int left = 0;
        int right = k;
        int sum = 0;
        while (left < k) {
            if (s.charAt(left) == 'a')
                sum++;
            else if (s.charAt(left) == 'e')
                sum++; 
            else if (s.charAt(left) == 'i')
                sum++;
            else if (s.charAt(left) == 'o')
                sum++;
            else if (s.charAt(left) == 'u')
                sum++;
            left++;
        }
        int maxl = sum;
        left = 0;
        while (right < s.length()) {
            if (s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o' || s.charAt(left) == 'u') {
                sum--;
            }
            if (s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i' || s.charAt(right) == 'o' || s.charAt(right) == 'u') {
                sum++;
            }
            maxl = Math.max(maxl, sum);
            right++;
            left++;
        }
        return maxl;
        
    }
}