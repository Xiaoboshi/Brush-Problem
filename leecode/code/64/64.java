class Solution {
    public int minPathSum(int[][] grid) {
        int leni = grid.length;
        int lenj = grid[0].length;
        int sum = 0;

        if (leni == 0 || lenj == 0)
            return 0;
        
        if (leni == 1) {
            for (int i = 0; i < lenj; i++)
                sum += grid[0][i];
            return sum;
        }
        if (lenj == 1) {
            for (int i = 0; i < leni; i++)
                sum += grid[i][0];
            return sum;
        }

        int [] dpi = new int[lenj];
        dpi[0] = grid[0][0];

        for (int i = 1; i < lenj; i++) {
            dpi[i] = dpi[i - 1] + grid[0][i];
        }
        int dpj = 0;
        
        for (int i = 1; i < leni; i++) {
            dpj = dpi[0] + grid[i][0];
            dpi[0] = dpj;
            for (int j = 1; j < lenj; j++) {
                dpj = grid[i][j] + Math.min(dpj, dpi[j]);
                dpi[j] = dpj;
            }
        }
        return dpj;
    }
}
