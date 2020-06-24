class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = Math.min(height[right],height[left]) * (height.length - 1);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            int temp = Math.min(height[right],height[left]) * (right - left);
            result = Math.max(temp, result);
        }
        return result;
    }
}