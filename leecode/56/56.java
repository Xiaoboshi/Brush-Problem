class Solution {
    public int[][] merge(int[][] intervals) {

        ArrayList<Integer> a = new ArrayList();
        ArrayList<Integer> b = new ArrayList();
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (max < intervals[i][0]) {
                a.add(min);
                b.add(max);
                min = intervals[i][0];
                max = intervals[i][1];
            } else {
                if (max <= intervals[i][1]) {
                    max = intervals[i][1];
                }
            }
        }
        a.add(min);
        b.add(max);

        int[][] result = new int[a.size()][2];
        for (int i = 0; i < a.size(); i++) {
            result[i][0] = a.get(i);
            result[i][1] = b.get(i);
        } 
        return result;
    }
}
