public class Solution {
    public String LeftRotateString(String str,int n) {
        
        int len = str.length();
        String b = "";
        
        if (len <= 0)
            return b;
        
        b = str.substring(0, n);
        String c = str.substring(n);
        
        c = c.concat(b);
        
        return c;
        
    }
}
