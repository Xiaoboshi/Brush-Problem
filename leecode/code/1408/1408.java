class Solution {
    public List<String> stringMatching(String[] words) {
        int[] record = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            record[i] = -1;
            for (int j = 0; j < words.length; j++) {
                if (words[j].indexOf(words[i]) != -1 && i != j) {
                    record[i] = i;
                    break;
                }
            }
        }
        
        ArrayList<String> s = new ArrayList();
        for (int i = 0 ; i < words.length; i++) {
            if (record[i] != -1) {
                s.add(words[record[i]]);
            }
        }
        return s;
    }
}