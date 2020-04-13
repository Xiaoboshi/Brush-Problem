class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        int [][] row = new int[len][len];
        row[len - 1][len - 1] = 1;

        for (int i = len - 1; i >= 0; i--) {
            row[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    row[i][j] = row[i + 1][j - 1] + 2;
                } else {
                    row[i][j] = Math.max(row[i + 1][j], row[i][j - 1]);
                }
            }
        }
        return row[0][len - 1];
    }
}
