class Solution {

    public int minDistance(String word1, String word2) {
        // 对操作进行等价
        // 1. word1插入一个字符
        // 2. word2插入一个字符
        // 3. word1替换一个字符

        int Alen = word1.length();
        int Blen = word2.length();
        if (Alen == 0 || Blen == 0) {
            return Math.max(Alen, Blen);
        }

        int[][] dp = new int[Alen][Blen];
        int[] dp2 = new int[Alen];
        int flag = 0;
        int flag2 = 0;
        if (word1.charAt(0) != word2.charAt(0)) {
            dp[0][0] = 1;
            dp2[0] = 1;
        } else {
            dp[0][0] = 0;
            dp2[0] = 0;
            flag = 1;
            flag2 = 1;
        }

        for (int i = 1; i < Alen; i++) {
            if (word1.charAt(i) == word2.charAt(0) && flag == 0) {
                dp2[i] = dp2[i - 1];
                flag = 1;
            } else {
                dp2[i] = dp2[i - 1] + 1;
            }
        }


        for (int i = 1; i < Blen; i++) {
            if (word1.charAt(0) == word2.charAt(i) && flag2 == 0) {
                dp[0][i] = dp[0][i - 1];
                flag2 = 1;
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }

        for (int i = 1; i < Alen; i++) {
            dp[i][0] = dp2[i];
            for (int j = 1; j < Blen; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, 
                                Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, 
                                Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[Alen - 1][Blen - 1];
    }
}
