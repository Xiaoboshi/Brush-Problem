class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length + 3];
        int sum = 0;
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for(int j = i; j < i + 3; j++) {
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        int alice = dp[0];
        int bob = sum - dp[0];
        if (alice == bob) {
            return "Tie";
        } else if (alice > bob) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}
