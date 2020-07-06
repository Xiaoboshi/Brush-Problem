class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();

        boolean[][] dp = new boolean[lens + 1][lenp + 1];
        dp[0][0] = true;

        for (int i = 1; i <= lenp; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= lens; i++) {
            char ti = s.charAt(i - 1);
            for (int j = 1; j <= lenp; j++) {
                char tj = p.charAt(j - 1);
                if (ti == tj || tj == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (tj == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[lens][lenp];
    }
}