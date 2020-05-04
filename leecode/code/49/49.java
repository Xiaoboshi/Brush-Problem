class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> record = new HashMap();

        for(int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String temp2 = String.valueOf(temp);
            if (!record.containsKey(temp2)) 
                record.put(temp2, new ArrayList());
            record.get(temp2).add(strs[i]);
        }
        return new ArrayList(record.values());

    }
}