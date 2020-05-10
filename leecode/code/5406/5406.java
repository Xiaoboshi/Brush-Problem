class Solution {
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Stack<Integer> a = new Stack();
        Map<Integer, List<Integer>> record = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> temp;
            if (record.containsKey(edges[i][0]))
                temp = record.get(edges[i][0]);
            else
                temp = new ArrayList();
            temp.add(edges[i][1]);
            record.put(edges[i][0], temp);
        }
        
        a.push(0);
        int res = 0;
        while (a.size() != 0) {
            int temp = a.peek();
            if (record.containsKey(temp)) {
                List<Integer> tempm = record.get(temp);
                if (tempm.size() == 0) {
                    record.remove(temp);
                } else {
                    int tempk = tempm.remove(0);
                    record.put(temp, tempm);
                    a.push(tempk);
                    res++;
                }
            } else {
                int k = a.pop();
                if (!a.isEmpty()) {
                    if (hasApple.get(k)) {
                        for (int x : a) {
                            hasApple.set(x, true);
                        }
                        res++;
                    } else {
                        res--;
                    }
                }
            }
        }
        return res;
    }
}