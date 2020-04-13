class Solution {
    public String reverseWords(String s) {
        String temp = "";
        String[] str = s.split("\\s+");
        if (str.length < 1 || s.equals("")) {
            return temp;
        }
        int tempn = 0;
        if (str[0].equals("")) {
            tempn = 1;
        }
        for (int i = str.length - 1; i > tempn; i--) {
            temp = temp + str[i];
            temp = temp + ' ';
        }
        temp = temp + str[tempn];
        return temp;
    }
}
