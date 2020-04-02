class Solution {

    public int getw(int x) {
        if (x == 1) {
            return 0;
        }
        int count = 0;
        if (x % 2 == 0) {
            count += getw(x >> 1) + 1;
        } else {
            count += getw(3 * x + 1) + 1;
        }
        return count;
    }

    public int getKth(int lo, int hi, int k) {

        PriorityQueue<int[]> a = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int i = lo; i <= hi; i++) {
            a.offer(new int[]{i, getw(i)});
            if (a.size() > k)
                a.poll();
        }
        return a.peek()[0];
    }
}
