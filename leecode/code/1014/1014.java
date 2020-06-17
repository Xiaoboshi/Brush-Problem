class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int ml = A[0] + 0;
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(ml + A[i] - i, res);


            ml = Math.max(A[i] + i, ml);
        }
        return res;
    }
}