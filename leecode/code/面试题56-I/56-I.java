class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        int a = 0;
        int b = 0;
        for (int x : nums) {
            res ^= x;
        }
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }
        for (int x : nums) {
            if ((div & x) == 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int[] result = {a, b};
        return result;
    }
}