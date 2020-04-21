class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        ArrayList<Integer> pos = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                pos.add(i);
            }
        }
        if (pos.size() < k) {
            return 0;
        }
        for (int i = 0; i <= pos.size() - k; i++) {
            int left = pos.get(i) - 1;
            int right = pos.get(i + k - 1) + 1;
            int lnum = 0;
            int rnum = 0;
            while (left >= 0 && nums[left] % 2 == 0) {
                left--;
                lnum++;
            }
            while (right < nums.length && nums[right] % 2 == 0) {
                right++;
                rnum++;
            }
            result += rnum + lnum + lnum * rnum + 1;
        }
        return result;
    }
}