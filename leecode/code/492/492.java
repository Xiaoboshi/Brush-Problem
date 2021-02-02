class Solution {
    public int[] constructRectangle(int area) {
        int n = (int) Math.sqrt(area);


        for (int i = n; i > 0; i++) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return null;
    }
}