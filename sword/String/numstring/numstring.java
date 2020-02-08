public class Solution {
    public boolean isNumeric(char[] str) {
        
        if (str.length == 0)
            return false;
        
        boolean exp = false;
        boolean point = false;
        int i = 0;
        
        for (; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if ((i + 1) < str.length){
                    if (str[i + 1] >= '0' && str[i + 1] <= '9')
                        continue;
                    if (str[i + 1] == '.')
                        continue;
                    else
                        return false;
                } else
                    return false;
            } else if (str[i] >= '0' && str[i] <= '9') {
                if ((i + 1) < str.length){
                    if (str[i + 1] == 'E' || str[i + 1] == 'e' || str[i + 1] == '.')
                        continue;
                    else if ((str[i + 1] >= '0' && str[i + 1] <= '9'))
                        continue;
                    else
                        return false;
                }
            } else if (str[i] == 'E' || str[i] == 'e') {
                if (exp == false) {
                    if ((i + 1) < str.length){
                        if (str[i + 1] == '+' || str[i + 1] == '-'){
                            exp = true;
                            continue;
                        }
                    } else {
                        return false;
                    }
                } else
                    return false;
            } else if (str[i] == '.') {
                if (point == false && exp == false) {
                    if ((i + 1) < str.length){
                        if ((str[i + 1] >= '0' && str[i + 1] <= '9')) {
                            point = true;
                            continue;
                        }
                    } else 
                        return false;
                } else
                    return false;
            }
        }
        if (i >= str.length)
            return true;
        return false;
    }
}
