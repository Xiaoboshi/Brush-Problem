class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - 1;
        
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += cardPoints[i];
        }
        int result = temp;
        for (int i = k - 1; i >= 0; i--) {
            temp -= cardPoints[i];
            temp += cardPoints[len--];
            result = Math.max(result, temp);
        }
        return result;
    }
}