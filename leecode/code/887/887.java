class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (j == 1) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left = 1;
                int right = i;
                while (left < right) {
                    int mid = (right - left + 1) / 2 + left;
                    int temp1 = dp[mid - 1][j - 1];
                    int temp2 = dp[i - mid][j];
                    if (temp1 > temp2) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }

        return dp[N][K];
    }
}
