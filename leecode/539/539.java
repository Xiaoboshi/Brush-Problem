class Solution {

    public int calsub(String str1, String str2) {
        String [] st1 = str1.split(":");
        int h1 = Integer.valueOf(st1[0]);
        int m1 = Integer.valueOf(st1[1]);

        String [] st2 = str2.split(":");
        int h2 = Integer.valueOf(st2[0]);
        int m2 = Integer.valueOf(st2[1]);
        return (h1 - h2) * 60 + m1 - m2;
    }

    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int halfmax = 12 * 60;

        Collections.sort(timePoints);
        int min = 0;
        int temp = 0;

        temp = calsub(timePoints.get(len - 1), timePoints.get(0));
        if (temp > halfmax) {
            temp = 2 * halfmax - temp;
        }
        min = temp;
        for (int i = 1; i < len; i++) {
            temp = calsub(timePoints.get(i), timePoints.get(i - 1));
            if (temp > halfmax) {
                temp = 2 * halfmax - temp;
            }
            min = Math.min(temp, min);
        }
        return min;
    }
}
