class Solution {
    public String compressString(String S) {
        String a = "";
        int [] b = new int[S.length()];
        int count = 0;

        for(int i = 0; i < S.length(); i++) {
            if (a.length() == 0) {
                a += S.charAt(i);
                b[count]++;
                count++;
            } else {
                if (S.charAt(i) == a.charAt(count - 1)) {
                    b[count - 1]++;
                } else {
                    a += S.charAt(i);
                    b[count]++;
                    count++;
                }
            }
        }
        if (2 * count >= S.length()) {
            return S;
        } else {
            String c = "";
            for (int i = 0; i < count; i++) {
                c += a.charAt(i);
                c += b[i];
            }
            return c;
        }
    }
}
