class Solution {
    public String largestMultipleOfThree(int[] digits) {
        String sum = "";
        
        Arrays.sort(digits);
        if (digits[digits.length - 1] == 0)
            return "0";
        
        int sumnum = 0;
        for (int i = 0; i < digits.length; i++) {
            sumnum += digits[i];
        }
        int temp = sumnum % 3;
        int kill = -1;
        int kill2 = -1;
        int m = 0;
        if (temp != 0) {
            for (m = 0; m < digits.length; m++) {
                if (digits[m] % 3 == temp) {
                    kill = m;
                    break;
                }
            }
            if (kill == -1 && m >= digits.length) {
                if (temp == 2)
                    temp = 1;
                if (temp == 1)
                    temp = 2;
                for (m = 0; m < digits.length; m++) {
                    if (kill != -1 && kill2 != -1)
                        break;
                    if (digits[m] % 3 == temp) {
                        if (kill == -1)
                            kill = m;
                        else if (kill2 == -1)
                            kill2 = m;
                    }
                }
            }
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != kill && i != kill2) {
                sum = sum + digits[i];
            }
        }
        return sum;
    }
        
}
