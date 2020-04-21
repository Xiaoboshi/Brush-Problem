class Solution {
    public int largestRectangleArea(int[] heights) {
        int num = heights.length;
        int max = 0;
        for (int i = 0; i < num; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < num && heights[right] >= heights[i]) {
                right++;
            }
            max = Math.max(max, heights[i] * (right - left - 1));
        }
        return max;
    }
}