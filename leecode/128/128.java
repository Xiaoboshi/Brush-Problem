class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet();
        for (int x : nums) {
            set.add(x);
        }
        int max = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int num = x;
                int count = 1;

                while(set.contains(num + 1)) {
                    num++;
                    count++;
                }
                max = Math.max(count, max);
            }
        }

        return max;
    }
}
