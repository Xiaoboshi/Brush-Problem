class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int[] res1 = new int[m];
        if (m <= 0)
            return res1;
        
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int l = (m + 1) / 2;
        int count = 0;
        for (int i = 0; i < l; i++) {
            int j = i;
            int k = i;
            for (; j < n - i && count < m * n; j++) {
                res[count] = matrix[k][j];
                count++;
            }
            j--;
            k++;
            for (; k < m - i && count < m * n; k++) {
                res[count] = matrix[k][j];
                count++;
            }
            k--;
            j--;
            for (; j >= i && count < m * n; j--) {
                res[count] = matrix[k][j];
                count++;
            }
            j++;
            k--;
            for (; k > i && count < m * n; k--) {
                res[count] = matrix[k][j];
                count++;
            }
        }
        return res;
    }
}