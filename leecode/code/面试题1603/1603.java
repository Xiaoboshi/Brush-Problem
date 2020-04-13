class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        // ax + by = c
        int a1 = end1[1] - start1[1];
        int b1 = start1[0] - end1[0];
        int c1 = a1 * start1[0] + b1 * start1[1];
        int a2 = end2[1] - start2[1];
        int b2 = start2[0] - end2[0];
        int c2 = a2 * start2[0] + b2 * start2[1];

        int a2b1 = a2 * b1;
        int a1b2 = a1 * b2;
        int a2c1 = a2 * c1;
        int a1c2 = a1 * c2;
        int b2c1 = b2 * c1;
        int b1c2 = b1 * c2;

        double[] a = {};
        if (a1b2 == a2b1) {
            int[][] temp = {{start1[0], start1[1]}, {end1[0], end1[1]}, 
                            {start2[0], start2[1]}, {end2[0], end2[1]}};
            Arrays.sort(temp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {return o1[1] - o2[1];}
                    else return o1[0] - o2[0];
                }
            });
            
            if (a1 != a2) {
                a = new double[2];
                a[0] = temp[1][0];
                a[1] = temp[1][1]; 
            }
            return a;
        }

        double y = 1.0 * (a2c1 - a1c2) / (a2b1 - a1b2);
        double x = 1.0 * (b2c1 - b1c2) / (a1b2 - a2b1);

        int flag = 0;
        if (x <= Math.max(start1[0], end1[0]) && x >= Math.min(start1[0], end1[0])) {
            if (y <= Math.max(start1[1], end1[1]) && y >= Math.min(start1[1], end1[1])) {
                flag++;
            }
        }
        if (x <= Math.max(start2[0], end2[0]) && x >= Math.min(start2[0], end2[0])) {
            if (y <= Math.max(start2[1], end2[1]) && y >= Math.min(start2[1], end2[1])) {
                flag++;
            }
        }
        if (flag == 2) {
            a = new double[2];
            a[0] = x;
            a[1] = y;
        }
        return a;
    }
}