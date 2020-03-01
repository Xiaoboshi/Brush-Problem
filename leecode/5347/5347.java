class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        if (m <= 1)
            return 0;
        int n = grid[1].length;
        int cost = 0;
        int[][] costm = new int[m][n];
        
        int x = 0;
        int y = 0;
        
        int[][] save = new int [m][n];
        
        while (true) {
            save[x][y] = 1;
            if (x == 0)
                costm[x][y] = cost;
            else {
                if (save[x - 1][y] == 1) {
                    costm[x][y] = Math.min(cost, costm[x - 1][y] + 1);
                    cost = costm[x][y];
                }
                else {
                    costm[x][y] = cost;
                }
            }
            
            if (x == m - 1 && y == n - 1)
                break;
            
            if (grid[x][y] == 1) {
                if (y == n - 1) {
                    grid[x][y] = 3;
                    x++;
                    cost++;
                } else {
                    y++;
                }
            }
            else if (grid[x][y] == 2) {
                if (y == 0) {
                    if (x == m - 1) {
                        grid[x][y] = 1;
                        cost++;
                        y++;
                    } else {
                        grid[x][y] = 3;
                        cost++;
                        x++;
                    }
                } else if (save[x][y - 1] == 1) {
                    if (x == m - 1) {
                        grid[x][y] = 1;
                        cost++;
                        y++;
                    } else {
                        grid[x][y] = 3;
                        cost++;
                        x++;
                    }
                } else {
                    y--;
                }
            } else if (grid[x][y] == 3) {
                if (x == m - 1) {
                    grid[x][y] = 1;
                    cost++;
                    y++;
                } else {
                    x++;
                }
            } else if (grid[x][y] == 4) {
                if (x == 0) {
                    if (y == n - 1) {
                        grid[x][y] = 3;
                        cost++;
                        x++;
                    } else {
                        grid[x][y] = 1;
                        cost++;
                        y++;
                    }
                } else if (save[x - 1][y] == 1) {
                    if (y == n - 1) {
                        grid[x][y] = 3;
                        cost++;
                        x++;
                    } else {
                        grid[x][y] = 1;
                        cost++;
                        y++;
                    }
                } else {
                    x--;
                }
            }
        }
        return costm[m - 1][n-1];
    }
}
