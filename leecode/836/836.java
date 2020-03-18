class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long row = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        long col = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        if (col > 0 && row > 0) {
            if (row * col > 0)
                return true;
        } 
        return false;
    }
}
