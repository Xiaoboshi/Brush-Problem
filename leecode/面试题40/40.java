class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        int [] num = new int[k];

        for (int i = 0; i < arr.length; i++) {
            q.offer(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            num[i] = q.poll();
        }
        return num;
    }
}
