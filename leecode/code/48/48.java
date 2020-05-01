class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len <= 1) {
            return;
        }
        int sum = len - 1;
        for (int i = 0; i < len / 2; i++) {
            int temp = len - 1 - 2 * i;
            for (int j = i; j < temp + i; j++) {
                int[] index = {i, sum - j, sum - i, j};
                int[] indey = {j, i, sum - j, sum - i};
                int temp2 = matrix[i][j];
                for (int k = 0; k < 3; k++) {
                    matrix[index[k]][indey[k]] = matrix[index[k + 1]][indey[k + 1]];
                }
                matrix[index[3]][indey[3]] = temp2;
            }
        }
    }
}