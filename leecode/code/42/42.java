class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int nowmax = 0;
        int temp = 0;
        int tomax = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[tomax]) {
                tomax = i;
            }
        }

        for (int i = 1; i <= tomax; i++) {
            if (height[i] >= height[nowmax]) {
                sum += height[nowmax] * (i - nowmax - 1) - temp;
                nowmax = i;
                temp = 0;
            } else {
                temp += height[i];
            }
        }
        
        temp = 0;
        nowmax = height.length - 1;
        for (int i = height.length - 2; i >= tomax; i--) {
            if (height[i] >= height[nowmax]) {
                sum += height[nowmax] * (nowmax - i - 1) - temp;
                nowmax = i;
                temp = 0;
            } else {
                temp += height[i];
            }
        }

        return sum;
    }
}
