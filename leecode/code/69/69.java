class Solution {
    public int mySqrt(int x) {
        long[] stan = new long[50000 + 1];
        for (int i = 0; i <= 50000; i++) {
            stan[i] = (long)i * i;
        }
        long num = (long)x;
        int res = 0;
        for (int i = 0; i <= 50000; i++) {
            if (num < stan[i]) {
                res = i;
                break;
            }
        }
        return res - 1;
    }
}