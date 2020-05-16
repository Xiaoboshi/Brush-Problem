class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0 || nums.length < 2) return nums;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> pl = new LinkedList();
        
        for (int i = 0; i < nums.length; i++) {
            while (!pl.isEmpty() && nums[pl.getLast()] <= nums[i])
                pl.removeLast();
            
            pl.addLast(i);
            while (pl.getFirst() <= i - k)
                pl.removeFirst();
            if (i + 1 >= k)
                res[i - k + 1] = nums[pl.getFirst()];
        }


        return res;
    }
}