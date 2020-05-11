class Solution {


    public double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = helper(x, n / 2);
        return (n % 2 == 0)? y * y : y * y * x;
    }


    public double myPow(double x, int n) {
        return (n > 0)? helper(x, n) : 1 / helper(x, -n); 
    }
}