class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int maxlimit = 0;
        Deque<Integer> maxq = new LinkedList();
        Deque<Integer> minq = new LinkedList();


        while (right < nums.length) {
            while (!maxq.isEmpty() && nums[maxq.peekLast()] < nums[right]) {
                maxq.pollLast();
            }
            while (!minq.isEmpty() && nums[minq.peekLast()] > nums[right]) {
                minq.pollLast();
            }
            maxq.add(right);
            minq.add(right);


            while (!maxq.isEmpty() && !minq.isEmpty() && 
                    (nums[maxq.peek()] - nums[minq.peek()]) > limit) {
                if (maxq.peek() <= left) maxq.poll();
                if (minq.peek() <= left) minq.poll();
                left++;
            }
            maxlimit = Math.max(maxlimit, right - left + 1);
            right++;
        }
        return maxlimit;
    }
}