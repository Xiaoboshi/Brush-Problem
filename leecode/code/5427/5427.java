class Solution {


    public int sum(int[] nums) {
        int summ = 0;
        for (int x : nums) {
            summ += x;
        }
        return summ;
    }


    public int count(int[] nums) {
        int countt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                countt++;
            }
        }
        return countt;
    }


    public double calc(int n, int[] balls) {
        double total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        for (int i = 0; i < balls.length; i++) {
            long temp = 1;
            for (int j = 1; j <= balls[i]; j++) {
                temp *= j;
            }
            total /= temp;
        }
        return total;
    }


    public double dfs(int n, int target,int[] b1, int[] b2, int[] balls) {
        double res = 0;
        if (n == target) {
            int sumb1 = sum(b1);
            int sumb2 = sum(b2);
            int coub1 = count(b1);
            int coub2 = count(b2);
            if (sumb1 == sumb2 && coub1 == coub2) {
                res = calc(sumb1, b1) * calc(sumb2, b2);
            }
            return res;
        }
        
        for (int i = 0; i <= balls[n]; i++) {
            b1[n] = i;
            b2[n] = balls[n] - i;
            res += dfs(n + 1, target, b1, b2, balls);
        }
        return res;
    }


    public double getProbability(int[] balls) {
        int n = balls.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += balls[i];
        }
        double total = calc(sum, balls);
        int[] b1 = new int[n];
        int[] b2 = new int[n];


        double reach = dfs(0, n, b1, b2, balls);


        return reach / total;
    }
}