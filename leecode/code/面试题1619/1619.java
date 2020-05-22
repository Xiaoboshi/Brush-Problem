class Solution {


    public int dfs(int[][] land, int x, int y) {
        if (land[x][y] != 0)
            return 0;


        land[x][y] = -1;
        int[] index = {-1, 0, 1};
        int[] indey = {-1, 0, 1};
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && i == j) {
                    continue;
                }
                if (x + index[i] >= 0 && x + index[i] < land.length && 
                    y + indey[j] >= 0 && y + indey[j] < land[0].length &&
                    land[x + index[i]][y + indey[j]] == 0) {
                        count += dfs(land, x + index[i], y + indey[j]);
                    }
            }
        }
        return count;
    }



    public int[] pondSizes(int[][] land) {
        int[] res = null;
        if (land.length <= 0) return res;
        Queue<Integer> q = new PriorityQueue();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int temp = 0;
                if (land[i][j] == 0) {
                    temp = dfs(land, i, j);
                }
                if (temp > 0)
                    q.add(temp);
            }
        }


        res = new int[q.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}