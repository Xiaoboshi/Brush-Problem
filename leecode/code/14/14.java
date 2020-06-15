class Solution {


    public String coms(String a, String b) {
        int la = a.length();
        int lb = b.length();


        String r = "";


        for (int i = 0; i < la && i < lb; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                r = r + a.charAt(i);
            } else {
                break;
            }
        }
        return r;
    }



    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        } 
        String res = strs[0];
        for (int i = 0; i < strs.length; i++) {
            res = coms(res, strs[i]);
        }
        return res;
    }
}