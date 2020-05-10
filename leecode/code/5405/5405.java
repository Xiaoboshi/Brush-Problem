class Solution {
    
    public int countTriplets(int[] arr) {
        
        int[][] dp = new int[arr.length][arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = dp[i][j - 1] ^ arr[j];
            }
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (dp[i][j - 1] == dp[j][k]) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
}