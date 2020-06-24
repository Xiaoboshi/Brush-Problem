class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, String> map = new HashMap();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            map.put(i, "");
        }

        int count = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = map.get(count);
            temp = temp + s.charAt(i);
            map.put(count, temp);
            
            if (count == numRows - 1) {
                flag = 1;
            }
            if (count == 0) {
                flag = 0;
            }

            if (flag == 0) {
                count++;
            } else {
                count--;
            }
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res = res + map.get(i);
        }
        return res;
    }
}