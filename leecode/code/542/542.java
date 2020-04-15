class Solution {

    public int[][] updateMatrix(int[][] matrix) {

        int row = matrix.length;
        if (row == 0) {
            return matrix;
        }
        int col = matrix[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0)
                    result[i][j] = 0;
                else
                    result[i][j] = 20000;
            }
        }

        // 左上
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i - 1) >= 0)
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                if ((j - 1) >= 0)
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
            }
        }
        // 左下
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                if ((i - 1) >= 0)
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                if ((j + 1) < col)
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
            }
        }
        // 右上
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if ((i + 1) < row)
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                if ((j - 1) >= 0)
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
            }
        }
        // 右下
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if ((i + 1) < row)
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                if ((j + 1) < col)
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
            }
        }

        return result;
    }
}