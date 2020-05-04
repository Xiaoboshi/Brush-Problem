class Solution {
    
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }; 
    
    public int merge(int[][] mat, int[] record, int row, int k, int znum) {
        // 优先队列，用于保存比较每次加和的大小
        PriorityQueue<Integer> q = new PriorityQueue(cmp);
        // 对每一行相加
        for (int i = znum; i < record.length; i++) {
            for (int j = 0; j < mat[row].length; j++) {
                q.add(record[i] + mat[row][j]);
                // 保证队列元素最大为k个
                if (q.size() > k) {
                    q.poll();
                }
            }
        }
        // 复制并返回下次加和record开始的位置
        int i = k - 1;
        while (!q.isEmpty()) {
            record[i] = q.poll();
            i--;
        }
        return i + 1;
    }
    
    public int kthSmallest(int[][] mat, int k) {
        // 用于保存前k个最小值的和
        int[] record = new int[k];
        // 如果矩阵每一行的值小于k个，统计一下下次从哪里开始
        int temp = k - 1;
        // 循环一次加上一行
        for (int i = 0; i < mat.length; i++) {
            temp =  merge(mat, record, i, k, temp);
        }
        
        return record[k - 1];
    }
}