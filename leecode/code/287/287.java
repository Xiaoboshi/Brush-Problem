class Solution {
    public int findDuplicate(int[] nums) {
        int tur = nums[nums[0]];
        int rabit = nums[nums[nums[0]]];


        while (rabit != tur) {
            tur = nums[tur];
            rabit = nums[nums[rabit]];
        }


        tur = nums[0];
        while (tur != rabit) {
            tur = nums[tur];
            rabit = nums[rabit];
        }
        
        return rabit;
    }
}