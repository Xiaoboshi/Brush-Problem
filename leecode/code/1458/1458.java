class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] dp = new int[l2];
        int[] dpp = new int[l2];
        Arrays.fill(dp, Integer.MIN_VALUE);
        Arrays.fill(dpp, Integer.MIN_VALUE);
        int res = Integer.MIN_VALUE;
        
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int ijn = nums1[i] * nums2[j];
                if (j == l2 - 1) {
                    dp[j] = Math.max(dpp[j], ijn);
                } else {
                    int temp = 0;
                    if (dpp[j + 1] != Integer.MIN_VALUE) {
                        temp = Math.max(ijn + dpp[j + 1], ijn);
                    } else {
                        temp = ijn;
                    }
                    dp[j] = Math.max(dpp[j], temp);
                }
                res = Math.max(dp[j], res);
            }
            dpp[l2 -1] = dp[l2 - 1];
            for (int k = l2 - 2; k >= 0; k--)
                dpp[k] = Math.max(dp[k], dpp[k + 1]);
        }
        
        return res;
    }
}