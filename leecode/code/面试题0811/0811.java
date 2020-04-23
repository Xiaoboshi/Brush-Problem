class Solution {
    public int waysToChange(int n) {
        long result = 0;     
        for (int i = 0; i <= n / 25; i++) {
            int a2 = n - i * 25;
            long first = n / 5 - i * 5 - a2 / 10 + 1;
            result += first * (a2 / 10 + 1) % 1000000007;
            result %= 1000000007;
        }
        return (int)result;
    }
}