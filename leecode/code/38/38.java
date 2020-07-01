class Solution {
    public String countAndSay(int n) {
        String[] sn = new String[n];
        sn[0] = "1";


        for (int i = 1; i < n; i++) {
            String tmp = "";
            String ls = sn[i - 1];
            
            for (int j = 0 ; j < ls.length(); j++) {
                int count = 0;
                char cp = ls.charAt(j);
                while (j < ls.length() && cp == ls.charAt(j)) {
                    j++;
                    count++;
                }
                tmp = tmp + String.valueOf(count);
                tmp = tmp + cp;
                j--;
            }
            sn[i] = tmp;
        }
        return sn[n - 1];
    }
}