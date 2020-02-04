public class Solution {
    public String ReverseSentence(String str) {
        
        int lenstr = str.length();
        
        String kl = "";
        String space = " ";
        if (lenstr == 0)
            return kl;
        
        String [] arr = str.split("\\s+");
        int len = arr.length;
        if (len == 0)
            return str;
        
        for (int i = len - 1; i > 0; i--) {
            kl = kl.concat(arr[i]);
            kl = kl.concat(space);
        }
        kl = kl.concat(arr[0]);
        
        return kl;
    }
}
