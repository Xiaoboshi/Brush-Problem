class Solution {


    Map<Integer, Integer>[] rows = new HashMap[9];
    Map<Integer, Integer>[] cols = new HashMap[9];
    Map<Integer, Integer>[] boxes = new HashMap[9];


    public void back(char[][] board, int row, int col) {
        if (row == 9) {
            return;
        }
        if (board[row][col] != '.') {
            if (col + 1 >= 9) {
                row += 1;
                col = -1;
            }
            back(board, row, col + 1);
        } else {
            int numt = row / 3;
            numt = numt * 3 + col / 3;
            for (int i = 0; i < 9; i++) {
                int lastr = row;
                int lastc = col;
                if (rows[row].containsKey(i + 1) || 
                    cols[col].containsKey(i + 1) ||
                    boxes[numt].containsKey(i + 1)) {
                    continue;
                } else {
                    char tmp = (char)(i + 1);
                    board[row][col] = tmp;
                    int lastcol = col;
                    int flag = 0;
                    rows[row].put(i + 1, 1);
                    cols[col].put(i + 1, 1);
                    boxes[numt].put(i + 1, 1);
                    if (col + 1 >= 9) {
                        lastr += 1;
                        lastc = -1;
                        flag = 1;
                    }
                    back(board, lastr, lastc + 1);
                    if (flag = 1) {}
                    board[row][col] = '.';
                    rows[row].remove(i + 1);
                    cols[col].remove(i + 1);
                    boxes[numt].remove(i + 1);
                }
            }
        }


    }



    public void solveSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i].put(num, 1);
                    cols[j].put(num, 1);
                    int numt = i / 3;
                    numt = numt * 3 + j / 3;
                    boxes[numt].put(num, 1);
                }
            }
        }


        back(board, 0, 0);
    }
}