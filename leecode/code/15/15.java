class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List< List<Integer>> a = new ArrayList();
        Arrays.sort(nums);
        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) {
            return a;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[i] + nums[right] == 0) {
                    ArrayList<Integer> b = new ArrayList();
                    b.add(nums[i]);
                    b.add(nums[left]);
                    b.add(nums[right]);
                    a.add(b);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[i] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return a;
    }
}