class Solution {
    public int maxProfit(int[] prices) {
        int dp_i_0 = Integer.MAX_VALUE;
        int dp_i_1 = 0;
        // 0 代表买入
        // 1 代表卖出
        // 状态转化
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.min(dp_i_0, prices[i]);
            dp_i_1 = Math.max(dp_i_1, prices[i] - dp_i_0);
        }
        return dp_i_1;
    }
}