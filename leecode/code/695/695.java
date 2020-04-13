class Solution {

    public int dfs(int[][] grid, int row, int col) {
        if (row == grid.length || row < 0 || col == grid[0].length 
            || col < 0 ||grid[row][col] == 0)
            return 0;
        
        grid[row][col] = 0;
        int [] indexx = {0, 0, 1, -1};
        int [] indexy = {1, -1, 0, 0};
        int ans = 1;

        for (int i = 0; i < 4; i++) {
            ans += dfs(grid, row + indexx[i], col + indexy[i]);
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int len = grid.length;
        int col = grid[0].length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }
}
