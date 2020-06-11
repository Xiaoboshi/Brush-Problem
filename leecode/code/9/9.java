class Solution {
    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);


        int left = 0;
        int right = temp.length() - 1;


        while (left <= right) {
            if (temp.charAt(left) != temp.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }


        return true;
    }
}