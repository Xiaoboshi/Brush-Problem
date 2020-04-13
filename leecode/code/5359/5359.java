class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long maxn = 0;
        long sum = 0;
        
        int [] t = new int [n];
        int [] v = new int[n];
        
        for (int i = 0; i < n; i++) {
            t[i] = efficiency[i];
        }
        Arrays.sort(t);
        
        for(int i = 0; i < n; i++) {
            sum = 0;      
            for (int j = 0; j < n; j++) {
                if (efficiency[j] < t[i])
                    speed[j] = 0;
            }
            
            for (int j = 0; j < n; j++) {
                v[j] = speed[j];
            }
            Arrays.sort(v);
            for (int j = 0; j < k; j++) {
                sum += v[n - j - 1];
            }
            maxn = Math.max(maxn, sum * t[i]);
        }
        
        return (int)(maxn % 1000000007);
    }
}
