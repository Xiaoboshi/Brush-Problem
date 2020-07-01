class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        long a = (long)dividend;
        long b = (long)divisor;
        int flag = 0;
        if ((a > 0 && b < 0) || (a < 0 && b > 0))
            flag = 1;
        a = Math.abs(a);
        b = Math.abs(b);


        long temp = div(a, b);
        if (flag == 1) {
            temp = -temp;
        }
        if (temp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (temp < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)temp;
        
    }


    public long div(long a, long b) {
        if (a < b) return 0;
        long tb = b;
        long count = 1;
        while ((tb + tb) < a) {
            tb = tb + tb;
            count = count + count;
        }
        return count + div(a - tb, b);
    }
}