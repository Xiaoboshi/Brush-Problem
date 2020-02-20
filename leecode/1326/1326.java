class Solution {
    public int minTaps(int n, int[] ranges) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 1;
        int [][] a = new int [n+1][2];
        ArrayList<Integer> record = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            if ((i - ranges[i]) < 0)
                a[i][0] = 0;
            else
                a[i][0] = i - ranges[i];
            if ((i + ranges[i]) > n)
                a[i][1] = n;
            else
                a[i][1] = i + ranges[i];
        }

        int left = 0;
        int right = a[0][1];
        int count = 1;
        record.add(0);
        for (int i = 0; i <= n; i++) {
            if (right < a[i][1]) {
                if (a[i][0] <= left) {
                    count = 1;
                    record.clear();
                    record.add(i);
                    right = a[i][1];
                } else if (right >= a[i][0]){
                    for (int j = 0; j < record.size(); j++) {
                        if (a[record.get(j)][1] >= a[i][0]){
                            j++;
                            while(j < record.size()) {
                                record.remove(j);
                            }
                            record.add(i);
                            count = record.size();
                            right = a[i][1];
                        }
                    }
                    right = a[i][1];
                }
            }
        }
        if (right < n)
            return -1;
        else
            return count;

    }
}
