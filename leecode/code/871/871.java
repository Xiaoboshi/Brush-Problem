class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {


        // dp[] 记录油数
        // dp[i] = Math.max()
        int[] dp = new int[stations.length + 1];
        int res = startFuel;
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        int flag = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                flag = i;
                break;
            }
        }


        return flag;
    }
}