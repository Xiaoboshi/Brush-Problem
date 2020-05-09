class Trie {
    Map<Character, PriorityQueue<String>> map;
    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        PriorityQueue<String> q;
        if (map.containsKey(word.charAt(0)))
            q = map.get(word.charAt(0));
        else
            q = new PriorityQueue();
        q.add(word);
        map.put(word.charAt(0), q);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (map.containsKey(word.charAt(0))) {
            PriorityQueue q = map.get(word.charAt(0));
            Object[] nn = q.toArray();
            for (int i = 0; i < nn.length; i++) {
                String temp = (String)nn[i];
                if (temp.equals(word)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (map.containsKey(prefix.charAt(0))) {
            PriorityQueue q = map.get(prefix.charAt(0));
            Object[] nn = q.toArray();
            for (int i = 0; i < nn.length; i++) {
                String temp = (String)nn[i];
                if (temp.indexOf(prefix) == 0) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */