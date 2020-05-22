class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        int[] dp = new int[32];
        Arrays.fill(dp, -2);
        dp[0] = -1;
        int len = 0;


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                res ^= (1 << 0);
            } else if (s.charAt(i) == 'e'){
                res ^= (1 << 1);
            } else if (s.charAt(i) == 'i'){
                res ^= (1 << 2);
            } else if (s.charAt(i) == 'o'){
                res ^= (1 << 3);
            } else if (s.charAt(i) == 'u'){
                res ^= (1 << 4);
            }
            if (dp[res] != -2) {
                int temp = i - dp[res];
                len = Math.max(len, temp);
            } else {
                dp[res] = i;
            }
        }
        return len;


    }
}