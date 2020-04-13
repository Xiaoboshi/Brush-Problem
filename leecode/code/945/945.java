class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            while (A[i] <= A[i - 1]) {
                count++;
                A[i]++;
            }
        }
        return count;
    }
}
