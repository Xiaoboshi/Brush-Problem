class Solution {
    
    int minc = Integer.MAX_VALUE;
    
    public void dfs(int[] houses, int[][] cost,int m, int n, int target, int ind, int costl, int last) {
        if (ind >= m) {
            if (target == 0) {
                minc = Math.min(minc, costl);
            }
            return;
        }
        if (houses[ind] != 0) {
            if (houses[ind] == last) {
                dfs(houses, cost, m, n, target, ind + 1, costl, houses[ind]);
            }else {
                dfs(houses, cost, m, n, target - 1, ind + 1, costl, houses[ind]);
            }
            
        } else {
      
            for (int i = 0; i < n; i++) {
                if (last == i + 1) {
                    dfs(houses, cost, m, n, target, ind + 1, costl + cost[ind][i], i + 1);
                } else {
                    dfs(houses, cost, m, n, target - 1, ind + 1, costl + cost[ind][i], i + 1);
                }
            }
        }
    }
    
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        if (houses.length == 0 || cost.length == 0 || cost[0].length == 0) {
            return -1;
        }
        if (houses[0] != 0) {
            dfs(houses, cost, m, n, target - 1, 1, 0, houses[0]);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(houses, cost, m, n, target - 1, 1, cost[0][i], i + 1);
            }
        }
        if (minc == Integer.MAX_VALUE) {
            minc = -1;
        }
        return minc;
    }
}