class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList();


        int max = -1;
        for (int x : candies)
            max = Math.max(max, x);
        
        for (int x : candies) {
            if (x + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}