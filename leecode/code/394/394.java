class Solution {


    public String dfs(String s) {
        if (s == "") {
            return "";
        }
        String res = "";
        int index = 0;
        while (index < s.length()) {
			if ((s.charAt(index) < '0' || s.charAt(index) > '9') && s.charAt(index) != '[' && s.charAt(index) != ']')
            res = res + s.charAt(index);
            index++;
        }
        String nums = "";
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            nums = nums + s.charAt(index);
            index++;
        }
        String temp = "";
        if (index < s.length() && s.charAt(index) == '[') {
            int count = 0;
            do {
                if (s.charAt(index) == '[') {
                    if (count != 0)
                        temp = temp + '[';
                    count++;
                } else if (s.charAt(index) == ']') {
                    count--;
                    if (count != 0)
                        temp = temp + ']';
                } else {
                    temp = temp + s.charAt(index);
                }
                index++;
            } while(index < s.length() && count != 0);
            temp = dfs(temp);
        }
        String k = "";
        if (nums.length() != 0) {
            int num = Integer.valueOf(nums);
            for (int i = 0; i < num; i++) {
                k = k + temp;
            }
        }
        String el = s.substring(index);
        return res + k + el;
    }



    public String decodeString(String s) {
        String res = s;
        while (res.indexOf('[') != -1) {
            res = dfs(res);
        }
        return res;
    }
}