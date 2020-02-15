class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int leni = obstacleGrid.length;
        int lenj = obstacleGrid[0].length;
        int [] dpi = new int[lenj];

        if (leni == 0 || lenj == 0)
            return 0;
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (leni == 1) {
            for (int i = 0; i < lenj; i++) {
                if (obstacleGrid[0][i] == 1)
                    return 0;
            }
            return 1;
        }
        if (lenj == 1) {
            for (int i = 0; i < leni; i++) {
                if (obstacleGrid[i][0] == 1)
                    return 0;
            }
            return 1;
        }

        for (int i = 0; i < lenj; i++) {
            if (obstacleGrid[0][i] != 1)
                dpi[i] = 1;
            else{
                while(i < lenj)
                    dpi[i++] = 0;
            }
        }
        int dpj = 0;

        for (int i = 1; i < leni; i++) {
            if (obstacleGrid[i][0] == 1)
                dpi[0] = 0;
            dpj = dpi[0];
            for (int j = 1; j < lenj; j++) {
                dpj += dpi[j];
                if (obstacleGrid[i][j] == 1) {
                    dpi[j] = 0;
                    dpj = 0;
                }
                else
                    dpi[j] = dpj;
            }
        }
        return dpj;
    }
}
