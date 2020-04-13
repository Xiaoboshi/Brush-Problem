class Solution {

    int[][] record;

    public int getsum(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }

        while (y != 0) {
            sum += y % 10;
            y = y / 10;
        }
        return sum;
    }

    public int search(int x, int y) {
        int[] index_x = {-1, 0, 1};
        int[] index_y = {-1, 0, 1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x + index_x[i] < record.length && x + index_x[i] >= 0                    
                    && y + index_y[j] < record[0].length && y + index_y[j] >= 0) {
                    if (record[x + index_x[i]][y + index_y[j]] == 1) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public int movingCount(int m, int n, int k) {
        if (k <= 0) {
            return 1;
        }
        int count = 0;
        record = new int[m][n];
        record[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (getsum(i, j) <= k && search(i, j) == 1) {
                    count++;
                    record[i][j] = 1;
                }
            }
        }
        return count;
    }
}
