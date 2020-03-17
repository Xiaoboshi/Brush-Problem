class Solution {

    public int countCharacters(String[] words, String chars) {
        int n = words.length;
        int tablen = chars.length();
        int count = 0;
        
        Map <Character, Integer> mapc = new HashMap<Character, Integer>();

        for (int i = 0; i < tablen; i++) {
            if (mapc. containsKey(chars.charAt(i))) {
                mapc.put(chars.charAt(i), mapc.get(chars.charAt(i)) + 1);
            } else {
                mapc.put(chars.charAt(i), 1);
            }
        }

        for (int i = 0; i < n; i++) {
            int temp = words[i].length();
            if (temp <= tablen) {
                Map <Character, Integer> mapt = new HashMap<Character, Integer>();
                mapt.putAll(mapc);
                int k = 0;
                for (int j = 0; j < temp; j++) {
                    if (mapt.containsKey(words[i].charAt(j))) {
                        if (mapt.get(words[i].charAt(j)) > 0) {
                            mapt.put(words[i].charAt(j), mapt.get(words[i].charAt(j)) - 1);
                        } else {
                            k = 1;
                            break;
                        }
                    } else {
                        k = 1;
                        break;
                    }
                }
                if (k == 0) {
                    count += words[i].length();
                }
            }
        }
        return count;
    }
}
