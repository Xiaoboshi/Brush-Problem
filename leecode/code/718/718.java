class Solution {
    public int findLength(int[] A, int[] B) {
        int r = A.length, c = B.length;
        int[][] dp = new int[r + 1][c + 1];
        int res = 0;


        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int temp = (A[i - 1] == B[j - 1])? 1: 0;
                if (temp != 0)
                    dp[i][j] = dp[i - 1][j - 1] + temp;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}