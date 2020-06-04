class Solution {


    public int dfs(int[][] matrix, int x, int y, int row, int col, int[][] rec) {      
        if (rec[x][y] != 0) {
            return rec[x][y];
        }


        int[] ix = {0, 0, 1, -1};
        int[] iy = {1, -1, 0, 0};


        for (int i = 0; i < 4; i++) {
            int m = x + ix[i];
            int n = y + iy[i];
            if (m < row && n < col && m >= 0 && n >= 0 && matrix[x][y] < matrix[m][n]) {
                int temp = dfs(matrix, m, n, row, col, rec);
                rec[x][y] = Math.max(rec[x][y], temp);
            }
        }
        return ++rec[x][y];
    }



    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) {
            return 0;
        }
        int col = matrix[0].length;
        int res = 0;
        int[][] rec = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = dfs(matrix, i, j, row, col, rec);
                res = Math.max(temp, res);
            }
        }
        return res;
    }
}