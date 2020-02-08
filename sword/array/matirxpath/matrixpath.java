public class Solution {
    
    boolean [] visit = null;
    
    public boolean hasPath1(char[] matrix, int rows, int cols, char[] str, 
                           int index, int row, int col)
    {
        int coord = row * cols + col;
        if (matrix[coord] != str[index] || visit[coord])
            return false;
        if (index == str.length - 1)
            return true;
        else { 
            visit[coord] = true;
            if ((row + 1) < rows)
                if (hasPath1(matrix, rows, cols, str, index + 1, row + 1, col))
                    return true;
            if (row > 0)
                if (hasPath1(matrix, rows, cols, str, index + 1, row - 1, col))
                    return true;
            if (col + 1 < cols)
                if (hasPath1(matrix, rows, cols, str, index + 1, row, col + 1))
                    return tru
            if (col > 0)
                return hasPath1(matrix, rows, cols, str, index + 1, row, col - 1);
            visit[coord] = false;
            return false;
        }
    }
    
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int len = str.length;
        
        if (str.length == 0)
            return true;
        char temp = str[0];
        int a = 0;
        int b = 0;
        boolean flag = false;
        visit = new boolean[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            a = i / cols;
            b = i % cols;
            flag = hasPath1(matrix, rows, cols, str, 0, a, b);
            if (flag == true)
                return flag;
        }
        return flag;
    }


}
