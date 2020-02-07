public class Solution {
    
    public boolean match1(char[] str, char[] pattern, int stri, int patj)
    {
        if ((str.length - stri) == 0 && (pattern.length - patj) == 0)
            return true;
        if ((str.length - stri) != 0 && (pattern.length - patj) == 0)
            return false;
        
        if (patj + 1 < pattern.length) {
            if (pattern[patj + 1] != '*') {
                if (stri < str.length) {
                    if (str[stri] == pattern[patj] || pattern[patj] == '.')
                        return match1(str, pattern, stri + 1, patj + 1);
                    else 
                        return false;
                } else {
                    return true;
                }
            } else {
                if (stri < str.length){
                    if (str[stri] == pattern[patj] || pattern[patj] == '.')
                        return match1(str, pattern, stri, patj + 2) || 
                        match1(str, pattern, stri + 1, patj);
                    else
                        return match1(str, pattern, stri, patj + 2);
                } else {
                    return match1(str, pattern, stri, patj + 2);
                }
            }
        } else {
            if ((str.length - stri) == 0) {
                if ((pattern.length - patj) != 0)
                    return false;
            } else {
                if ((str.length - stri) > (pattern.length - patj))
                    return false;
                else if (str[stri] == pattern[patj] || pattern[patj] == '.')
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
    
    public boolean match(char[] str, char[] pattern)
    {
        return match1(str, pattern, 0, 0);
    }
}
