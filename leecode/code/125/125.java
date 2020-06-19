class Solution {
    public boolean isPalindrome(String s) {
        // String rec = "";
        StringBuffer rec = new StringBuffer();
        int n = s.length();


        for (int i = 0; i < n; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                rec.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int left = 0;
        int right = rec.length() - 1;
        while (left < right) {
            if (rec.charAt(left) != rec.charAt(right)) {
                return false;
            }


            left++;
            right--;
        }
        return true;
    }
}

