class Solution {

    public int count(int[] rating, int index){
        int left = 0;
        int right = 0;
        int leftmax = 0;
        int rightmax = 0;
        int total = 0;

        for (int i = 0; i < index; i++) {
            if (rating[i] < rating[index]) {
                left++;
            } else if (rating[i] > rating[index]){
                right++;
            }
        }
        
        for (int i = index + 1; i < rating.length; i++) {
            if (rating[i] < rating[index]) {
                leftmax++;
            } else if (rating[i] > rating[index]){
                rightmax++;
            }
        }
        total = leftmax * right + left * rightmax;

        return total;
    }

    public int numTeams(int[] rating) {
        int total = 0;
        if (rating.length < 3)
            return 0;
        for (int i = 1; i < rating.length - 1; i++) {
            total += count(rating, i);
        }
        return total;
    }
}
