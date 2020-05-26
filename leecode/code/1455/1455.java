class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] a = sentence.split(" ");
        int res = -1;
        int i = 0;
        for (String x : a) {
            if (x.indexOf(searchWord) == 0){
                res = i + 1;
                break;
            }
            i++;
        }
        return res;
    }
}