class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int nums = 0;
            for (int j = i; j < s.length() && j < i + 2; j++) {
                nums = nums * 10 + (s.charAt(j) - '0');
                if (nums <= 26)
                    dp[i] += dp[j + 1];
            }
        }
        return dp[0];
    }
}