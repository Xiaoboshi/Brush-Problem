class Solution {
    
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }; 
    
    public int merge(int[][] mat, int[] record, int row, int k, int znum) {
        // ���ȶ��У����ڱ���Ƚ�ÿ�μӺ͵Ĵ�С
        PriorityQueue<Integer> q = new PriorityQueue(cmp);
        // ��ÿһ�����
        for (int i = znum; i < record.length; i++) {
            for (int j = 0; j < mat[row].length; j++) {
                q.add(record[i] + mat[row][j]);
                // ��֤����Ԫ�����Ϊk��
                if (q.size() > k) {
                    q.poll();
                }
            }
        }
        // ���Ʋ������´μӺ�record��ʼ��λ��
        int i = k - 1;
        while (!q.isEmpty()) {
            record[i] = q.poll();
            i--;
        }
        return i + 1;
    }
    
    public int kthSmallest(int[][] mat, int k) {
        // ���ڱ���ǰk����Сֵ�ĺ�
        int[] record = new int[k];
        // �������ÿһ�е�ֵС��k����ͳ��һ���´δ����￪ʼ
        int temp = k - 1;
        // ѭ��һ�μ���һ��
        for (int i = 0; i < mat.length; i++) {
            temp =  merge(mat, record, i, k, temp);
        }
        
        return record[k - 1];
    }
}