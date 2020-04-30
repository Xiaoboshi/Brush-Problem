class Solution {
    public boolean isHappy(int n) {
        int num = 0;
        int count = Integer.MAX_VALUE;
        while(num <= 100000 && count != 1) {
            count = 0;
            while (n / 10 != 0 || n % 10 != 0) {
                int temp = n % 10;
                n /= 10;
                count += temp * temp;
            }
            n = count;
            num++;
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}