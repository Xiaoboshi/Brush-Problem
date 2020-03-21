class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int sum = 0;
        int count = 0;
        int temp = threshold * k;

        for (int i = 0; i < arr.length - k + 1; i++) {
            sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += arr[j];
            }
            if (sum >= temp)
                count++;
        }
        return count;
    }
}
