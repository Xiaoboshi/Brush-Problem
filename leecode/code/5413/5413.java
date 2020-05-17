class Solution {
    public String arrangeWords(String text) {
        if (text.length() == 0) {
            return "";
        }
        String[] record = text.split(" ");
        Map<Integer, ArrayList<String>> map = new HashMap();
        PriorityQueue<Integer> q = new PriorityQueue();
        
        for (int i = 0; i < record.length; i++) {
            ArrayList<String> temp;
            int len = record[i].length();
            if (map.containsKey(len)) {
                temp = map.get(len);
            } else {
                temp = new ArrayList();
            }
            if (i == 0) {
                record[i] = record[i].toLowerCase();
            }
            temp.add(record[i]);
            q.add(len);
            map.put(len, temp);
        }
        String res = "";
        while (!q.isEmpty()) {
            int temp = q.poll();
            if (map.containsKey(temp)) {
                ArrayList<String> k = map.get(temp);
                res = res + k.remove(0);
                if (k.size() == 0) {
                    map.remove(temp);
                }
                map.put(temp, k);
            }
            res = res + " ";
        }
        return res.substring(0, 1).toUpperCase() + res.substring(1, text.length());
    }
}