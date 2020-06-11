class Solution {
    public String intToRoman(int num) {
        int[] rec = {1, 10, 100, 1000};
        String[] recs = {"I", "X", "C", "M"};
        String[] recfs = {"V", "L", "D", ""};
        int[] ts = {4, 9, 40, 90, 400, 900};
        String[] tss = {"IV", "IX", "XL", "XC", "CD", "CM"};
        Map<Integer, String> map = new HashMap();
        for (int i = 0; i < ts.length; i++) {
            map.put(ts[i], tss[i]);
        }


        String res = "";
        int c1 = 3;
        while (num > 0) {
            int div = num / rec[c1];
            int temp = div * rec[c1];
            num %= rec[c1];
            if (map.containsKey(temp)) {
                res = res + map.get(temp);
            } else {
                if (div >= 5) {
                    res = res + recfs[c1];
                    div -= 5;
                }
                for (int i = 0; i < div; i++) {
                    res = res + recs[c1];
                }
            }
            c1--;
        }
        return res;



    }
}