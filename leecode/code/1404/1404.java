class Solution {
    public int numSteps(String s) {
        int len = s.length() - 1;
        int step = 0;
        if (s.length() == 1) {
            return 0;
        }
        while(len >= 0) {
            if (s.charAt(len) == '0') {
                s = s.substring(0, len);
                len--;
            } else {
                String temp = "";
                int i = 0;
                for (i = len; i >= 0; i--) {
                    if (s.charAt(i) == '0') {
                        break;
                    }
                }
                for (int j = 0; j < i; j++) {
                    temp = temp + s.charAt(j);
                }
                temp = temp + '1';
                if (i < 0)
                    len++;
                for (int j = i + 1; j <= len; j++) {
                    temp = temp + '0';
                }
                s = temp;
            }
            step++;
            if (s.equals("1")) {
                break;
            }
        }
        return step;
    }
}
