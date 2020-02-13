class Solution {

    public String huiwen(String s, int centera, int centerb) {
        int len = s.length();
        while (centera >= 0 && centerb < len && s.charAt(centera) == s.charAt(centerb)) {
            centera--;
            centerb++;
        }
        return s.substring(centera + 1, centerb);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        String max = "";
        String lena = "";
        String lenb = "";
        int lenmax = 0;

        for (int i = 0; i < len; i++) {
            lena = huiwen(s, i, i);
            lenb = huiwen(s, i, i + 1);
            if (lena.length() < lenb.length()) {
                if (max.length() < lenb.length())
                    max = lenb;
            } else {
                if (max.length() < lena.length())
                    max = lena;
            }
        }
        return max;
    }
}
