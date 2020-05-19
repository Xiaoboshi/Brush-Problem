class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;


        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return (left >= right) || helper(s, left, right - 1) || helper(s, left + 1, right);
    }


    public boolean helper(String s, int left, int right) {
         while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        } 
        return left >= right;
    }
}