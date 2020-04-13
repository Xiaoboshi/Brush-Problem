class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int label = 0;

        int[] answer = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                answer[i] = (label % 2);
                label++;
            } else {
                label--;
                answer[i] = (label % 2);
            }
        }
        return answer;
    }
}
