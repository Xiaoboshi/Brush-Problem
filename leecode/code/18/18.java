class Solution {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;


        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int temp = nums[i] + nums[j];
                int left = j + 1;
                int right = n - 1;


                while (left < right) {
                    int tempd = temp + nums[left] + nums[right];
                    if (tempd == target) {
                        List<Integer> lk = new ArrayList();
                        lk.add(nums[i]);
                        lk.add(nums[j]);
                        lk.add(nums[left]);
                        lk.add(nums[right]);
                        res.add(lk);
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        
                        left++;
                        right--;
                    }
                    else if (tempd < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}