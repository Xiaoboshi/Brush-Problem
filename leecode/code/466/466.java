class Solution {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int result = 0;
        int counts1 = 0;
        int counts2 = 0;
        int points2 = 0;
        int points1 = 0;
        
        do {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(points2)) {
                    points2++;
                }
                if (points2 == s2.length()) {
                    points2 = 0;
                    counts2++;
                }
            }
            counts1++;
        } while(points2 != 0 && counts1 < n1);
        if (points2 != 0 && counts1 == n1) {
            result = counts2 / n2;
        } else {
            result = n1 / n2 * counts2 / counts1;
        }
        return result;
    }
}