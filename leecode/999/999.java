class Solution {
    public int numRookCaptures(char[][] board) {
        int len = board.length;
        int rx = 0;
        int ry = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }
        int count = 0;
        for (int i = rx + 1; i < len; i++) {
            if (board[i][ry] != '.') {
                if (board[i][ry] == 'p') {
                    count++;
                }
                break;
            }
        }
        for (int i = rx - 1; i >= 0; i--) {
            if (board[i][ry] != '.') {
                if (board[i][ry] == 'p') {
                    count++;
                }
                break;
            }
        }
        for (int i = ry + 1; i < len; i++) {
            if (board[rx][i] != '.') {
                if (board[rx][i] == 'p') {
                    count++;
                }
                break;
            }
        }
        for (int i = ry - 1; i >= 0; i--) {
            if (board[rx][i] != '.') {
                if (board[rx][i] == 'p') {
                    count++;
                }
                break;
            }
        }
        return count;
    }
}
