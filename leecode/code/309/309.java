class Solution {
    public int maxProfit(int[] prices) {
        int dpi0 = 0;
        int dpi1 = Integer.MIN_VALUE;
        int dpi_pre = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpi_pre - prices[i]);
            dpi_pre = temp;
        }
        return dpi0;
    }
}