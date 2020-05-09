class Solution {
    public int[] countBits(int num) {
        // 0 
        // 1
        // 1 2
        // 1 2 2 3
        // 1 2 2 3 2 3 3 4


        // 0
        // 1
        // 2 3
        // 4 5 6 7
        // 8 9 10 11 12 13 14 15
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i / 2] + i % 2;
        }
        return res;
    }
}