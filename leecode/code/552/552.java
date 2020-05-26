class Solution {
    public int checkRecord(int n) {
        int mod = 1000000007;
        long[] f = new long[(5 < n)? n + 1: 6];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;


        for (int i = 4; i <= n; i++) 
            f[i] = (2 * f[i - 1] % mod + (mod - f[i - 4])) % mod;
        
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            long temp = (f[i - 1] * f[n - i]) % mod;
            sum = (sum + temp) % mod;
        }


        
        return (int)sum;
    }
}