class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        int last = 0;
        for (int i = 1; i <= days.length; i++) {
            int j = 0;
            while (j < i) {
                if (days[i - 1] - days[j] + 1 <= 7) {
                    break;
                }
                j++;
            }
            int k = 0;
            while (k < i) {
                if (days[i - 1] - days[k] + 1 <= 30) {
                    break;
                }
                k++;
            }
            dp[i] = Math.min(dp[i - 1] + costs[0], 
                    Math.min(dp[j] + costs[1], dp[k] + costs[2]));
        }
        return dp[days.length];
    }
}