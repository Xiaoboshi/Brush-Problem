class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] cols = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (rows[i].containsKey(num)) {
                        return false;
                    } else {
                        rows[i].put(num, 1);
                    }
                    if (cols[j].containsKey(num)) {
                        return false;
                    } else {
                        cols[j].put(num, 1);
                    }
                    int numt = i / 3;
                    numt = numt * 3 + j / 3;
                    if (boxes[numt].containsKey(num)) {
                        return false;
                    } else {
                        boxes[numt].put(num, 1);
                    }
                }
            }
        }
        return true;
    }
}