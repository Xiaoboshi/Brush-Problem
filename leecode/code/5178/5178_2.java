class Solution {
    
    public int isfour(int a) {
        int sum = 0;
        int count = 0;
        int temp = (int)Math.sqrt(a);
        for(int i = 2 ; i <= temp; i++) {
            if (a % i == 0) {
                count++;
                sum += i;
            }
        }
        if (count == 1 && temp * temp != a){
            sum += a / sum;
            sum += 1 + a;
            return sum;
        } else {
            return -1;
        }
    }
    
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = isfour(nums[i]);
            if (temp != -1) {
                sum += temp;
            }
        }
        return sum;
    }
}
