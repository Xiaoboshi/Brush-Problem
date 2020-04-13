class Solution {
    
    public int numOfWays(int n) {
        
        int mod = 1000000007;
        
        long A = 6;
        long B = 6;
        
        while (n > 1) {
            long x = (2 * A + 2 * B) % mod;
            long y = (2 * A + 3 * B) % mod;
            A = x;
            B = y;
            n--;
        }
        
        return (int)(A + B) % mod;

    }
}
    
