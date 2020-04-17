class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int count = 0;
        int start = nums[0];
        if (start == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 1;
                int temp = i - 1;
                while(i + 1 < nums.length && nums[i + 1] == 0) {
                    i++;
                    count++;
                }
                int k = 0;
                for (int j = 0; j <= temp; j++) {
                    if (i == nums.length - 1) {
                        if (count <= nums[temp - j] - j) {
                            k = 1;
                            break;
                        }
                    } else {
                        if (count < nums[temp - j] - j) {
                            k = 1;
                            break;
                        }
                    }
                }
                if (k == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}