class Pair {
    int idx = 0;
    int value = 0;

    public Pair(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        LinkedList<Pair> a = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (!a.isEmpty() && a.getFirst().idx < i - k) {
                a.pollFirst();
            }
            Pair temp = new Pair(i, nums[i]);
            if (!a.isEmpty()) {
                temp.value = Math.max(temp.value, a.getFirst().value + nums[i]);
            }
            result = Math.max(result, temp.value);
            while (!a.isEmpty() && a.getLast().value < temp.value) {
                a.pollLast();
            }
            a.add(temp);
        }
        return result;
    }
}