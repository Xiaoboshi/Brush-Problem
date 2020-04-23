class Solution {
    public int hammingDistance(int x, int y) {
        int lenx = 0;
        int leny = 0;
        int result = 0;

        for (int i = 0; i < 31; i++) {
            lenx = x % 2;
            leny = y % 2;
            x /= 2;
            y /= 2;
            if (lenx != leny)
                result++;
        }
        return result;
    }
}