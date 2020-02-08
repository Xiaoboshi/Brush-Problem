public class Solution {
    
    public boolean [][] visit = null;
    
    int ans = 0;
    
    public int coordsum(int row, int col) {
        int sum = 0;
        while (row % 10 != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col % 10 != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum;
    }
    
    public int ismoving(int threshold, int row, int col, int rows, int cols) {
        if (row >= rows)
            return 0;
        if (col >= cols)
            return 0;
        if (row < 0)
            return 0;
        if (col < 0)
            return 0;
        if (coordsum(row, col) > threshold)
            return 0;
        if (visit[row][col])
            return 0;
        if (coordsum(row, col) <= threshold){
            visit[row][col] = true;
            ans += 1;
            ismoving(threshold, row - 1, col, rows, cols);
            ismoving(threshold, row + 1, col, rows, cols);
            ismoving(threshold, row, col - 1, rows, cols);
            ismoving(threshold, row, col + 1, rows, cols);
        }
        return 0;
    }
    
    
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;
        
        int count = 0;
        visit = new boolean [rows][cols];
        ismoving(threshold, 0, 0, rows, cols);
        return ans;
    }
}
