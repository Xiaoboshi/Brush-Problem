class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int start = len / 2;
        len--;

        for (int i = 0; i < start; i++) {
            int temp = len - i;
            for (int j = i; j < temp; j++) {
                int[] index_x = {i, j, len - i, len - j};
                int[] index_y = {j, len - i, len - j, i};
                int cache = matrix[index_x[3]][index_y[3]];
                for (int k = 2; k >= 0; k--) {
                    matrix[index_x[k + 1]][index_y[k + 1]] = matrix[index_x[k]][index_y[k]];
                }
                matrix[index_x[0]][index_y[0]] = cache;
            }
        }
    }
}
