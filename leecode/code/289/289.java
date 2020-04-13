class Solution {

    public int search(int[][] board, int x, int y) {
        int[] delx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dely = {0, 0, 1, -1, 1, -1, -1, 1};
        int count = 0;

        for (int i = 0; i < 8; i++) {
            if (x + delx[i] < board.length && x + delx[i] >= 0 && 
                y + dely[i] < board[0].length && y + dely[i] >=0) {
                if (board[x + delx[i]][y + dely[i]] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] nboard = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nboard[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = search(nboard, i, j);
                if ((temp > 3 || temp < 2) && nboard[i][j] == 1) {
                    board[i][j] = 0;
                } else if (temp == 3 && nboard[i][j] == 0) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
