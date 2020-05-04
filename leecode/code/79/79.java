class Solution {
    public boolean seeach(char[][] board, int[][] rec, int x, int y, int s, String word) {
        if (s >= word.length()) {
            return true;
        } 
        int[] index = {-1, 1, 0, 0};
        int[] indey = {0, 0, -1, 1};
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (x + index[i] < board.length && x + index[i] >= 0 &&
                y + indey[i] < board[0].length && y + indey[i] >= 0) {
                if (board[index[i] + x][indey[i] + y] == word.charAt(s) &&
                    rec[index[i] + x][indey[i] + y] == 0) {
                    rec[index[i] + x][indey[i] + y] = 1;
                    flag = flag || seeach(board, rec, x + index[i], y + indey[i], s + 1, word);
                    rec[index[i] + x][indey[i] + y] = 0;
                }
            }
        }
        return flag;
    }


    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int start = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(start) == board[i][j]) {
                    int[][] record = new int[row][col];
                    record[i][j] = 1;
                    boolean flag = seeach(board, record, i, j, start + 1, word);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}