class Solution {

    int count = 0;

    public void search(char[][] grid, int x, int y, int row, int col) {
        int[] inx = {-1, 1, 0, 0};
        int[] iny = {0, 0, -1, 1};

        int num = 0;
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            if (x + inx[i] < row && x + inx[i] >= 0 && y + iny[i] < col && y + iny[i] >= 0) {
                if (grid[x + inx[i]][y + iny[i]] != '0') {
                    search(grid, x + inx[i], y + iny[i], row, col);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j, row, col);
                    count++;
                }
            }
        }
        return count;
    }
}