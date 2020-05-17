class Solution {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap();
        List<Integer> q = new ArrayList();
        int[] record = new int[numCourses];
        int[] res = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> temp = new ArrayList();
            if (map.containsKey(prerequisites[i][1])) {
                temp = map.get(prerequisites[i][1]);
            } else {
                temp = new ArrayList();
            }
            temp.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], temp);
            record[prerequisites[i][0]]++;
        }


        for (int i = 0; i < numCourses; i++) {
            if (record[i] == 0) {
                q.add(i);
            }
        }


        int count = 0;
        while (!q.isEmpty()) {
            int as = q.remove(0);


            if (map.containsKey(as)) {
                List<Integer> temp = map.get(as);
                for (int x : temp) {
                    record[x]--;
                    if (record[x] == 0) {
                        q.add(x);
                    }
                }
            }
            res[count++] = as;
        }
        if (count < numCourses) {
            int[] ress = new int[0];
            return ress;
        }
        return res;
    }
}