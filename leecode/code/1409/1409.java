class Solution {
    public int[] processQueries(int[] queries, int m) {
        ArrayList<Integer> record = new ArrayList();
        int[] result = new int[queries.length];
        
        for (int i = 0; i < m; i++) {
            record.add(i + 1);
        }
        
        int tempk = 0;
        for (int i = 0; i < queries.length; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (queries[i] == record.get(j) ) {
                    int temp = record.remove(j);
                    record.add(0, temp);
                    break;
                }
            }
            result[i] = j;
            tempk++;
        }
        return result;
    }
}