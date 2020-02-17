class Solution {
    public int maxArea(int[] height) {
        int len = height.length;

        if (len <= 1)
            return 0;
        
        int left = 0;
        int right = len - 1;
        int maxarea = 0;

        while(left < right) {
            maxarea = Math.max(maxarea, 
                Math.min(height[left], height[right]) * (right - left));
            if (height[right] < height[left])
                right--;
            else
                left++;
        }
        return maxarea;
    }
}
