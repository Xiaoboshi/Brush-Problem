class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int last = 0;
        for (int i = 0; i < n; i++) {
            a.add(i);
        }
        for (int i = 0; i < n - 1; i++) {
            last = (last + m - 1) % a.size();
            a.remove(last);
        }
        return a.get(0);
    }
}
