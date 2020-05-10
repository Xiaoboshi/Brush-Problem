class Solution {
    public int ways(String[] pizza, int k) {
        int mod = 1000000007;
        int rows = pizza.length;
        if (rows <= 0) {
            return 0;
        }
        int cols = pizza[0].length();
        long[][][] dp = new long[rows][cols][k];
        long[][] nums = new long[rows][cols];
        
        // 统计pizza[i:][j:]的苹果个数
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int temp = 0;
                if (pizza[i].charAt(j) == 'A')
                    temp = 1;
                if (i == rows - 1 && j == cols - 1)
                    nums[i][j] = temp;
                else if (i == rows - 1)
                    nums[i][j] = temp + nums[i][j + 1];
                else if (j == cols - 1)
                    nums[i][j] = temp + nums[i + 1][j];
                else
                    nums[i][j] = temp + nums[i + 1][j]
                         + nums[i][j + 1] - nums[i + 1][j + 1]; 
            }
        }


        // dp[i][j][p] = sum(dp[x][j][p] 
        // for x in [i+1,m-1]) + sum(dp[i][y][p] for y in [j+1, n-1])
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (nums[i][j] > 0)
                    dp[i][j][0] = 1;
                for (int p = 1; p < k; p++) {
                    for (int pl = i + 1; pl < rows; pl++) {
                        if (nums[i][j] - nums[pl][j] > 0) {
                            dp[i][j][p] += dp[pl][j][p - 1] % mod;
                            dp[i][j][p] %= mod;
                        }
                    }
                    for (int pk = j + 1; pk < cols; pk++) {
                        if (nums[i][j] - nums[i][pk] > 0) {
                            dp[i][j][p] += dp[i][pk][p - 1] % mod;
                            dp[i][j][p] %= mod;
                        }
                    }
                }
            }
        }
        return (int)dp[0][0][k - 1] % mod;
    }
}

