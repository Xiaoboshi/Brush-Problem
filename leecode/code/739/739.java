class Solution {

    public int[] dailyTemperatures(int[] T) {
        int[] record = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    temp = j - i;
                    break;
                }
            }
            record[i] = temp;
        }
        return record;
    }
}
