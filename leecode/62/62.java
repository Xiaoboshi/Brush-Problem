class Solution {

    public int uniquePaths(int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        if (m == 1 || n == 1)
            return 1;

        int [] dpi = new int[n];
        for (int i = 0; i < n; i++)
            dpi[i] = 1;
        int dpj = 1;
        
        for (int i = 1; i < m; i++) {
            dpj = dpi[0];
            for (int j = 1; j < n; j++) { 
                dpj = dpi[j] + dpj;
                dpi[j] = dpj;
            }
        }
        
        return dpj;
        
    }
}
