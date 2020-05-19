class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;


        int[] left = new int[col];
        int[] right = new int[col];
        int[] h = new int[col];
        int res = 0;
        Arrays.fill(right, col);


        for (int i = 0; i < row; i++) {
            int cleft = 0;
            int crigth = col;
            // 更新最高的值
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1')
                    h[j]++;
                else
                    h[j] = 0;
            }
            // 更新左边界
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') 
                    left[j] = Math.max(left[j], cleft);
                else {
                    left[j] = 0;
                    cleft = j + 1;
                }
            }


            // 更新左边界
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') 
                    right[j] = Math.min(crigth, right[j]);
                else {
                    right[j] = col;
                    crigth = j;
                }
            }
            for (int j = 0; j < col; j++) {
                res = Math.max(res, (right[j] - left[j]) * h[j]);
            }
        }
        return res;
    }
}