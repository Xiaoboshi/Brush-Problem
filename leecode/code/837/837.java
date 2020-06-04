class Solution {


    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double s = 0;
        for (int i = K; i < dp.length; i++) {
            dp[i] = (i > N)? 0: 1;
            s += dp[i];
        }


        for (int i = K - 1; i >= 0; i--) {
            dp[i] = s / W;
            s = s + dp[i] - dp[i + W];
        }


        return dp[0];


    }
}