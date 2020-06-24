class Solution {
    public int reverse(int x) {
        long rec = 0;
        int flag = (x < 0) ? -1: 1;


        x = (x > 0)? x: -x;


        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            rec = 10 * rec + temp;
        }
        rec *= flag;
        if (rec > Integer.MAX_VALUE || rec < Integer.MIN_VALUE) {
            return 0;
        } else{
            return (int)rec;
        }


    }
}