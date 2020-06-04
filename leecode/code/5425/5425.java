class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hn = horizontalCuts.length;
        int vn = verticalCuts.length;
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long[] hnum = new long[hn + 1];
        long[] vnum = new long[vn + 1];
        
        hnum[0] = horizontalCuts[0];
        for (int i = 1; i < hn; i++) {
            hnum[i] = horizontalCuts[i] - horizontalCuts[i - 1];
        }
        hnum[hn] = h - horizontalCuts[hn - 1];
        
        vnum[0] = verticalCuts[0];
        for (int i = 1; i < vn; i++) {
            vnum[i] = verticalCuts[i] - verticalCuts[i - 1];
        }
        vnum[vn] = w - verticalCuts[vn - 1];
        
        Arrays.sort(hnum);
        Arrays.sort(vnum);
        
        long res = ((hnum[hn] % mod) * (vnum[vn] % mod)) % mod;
        
        return (int)res;
    }
}