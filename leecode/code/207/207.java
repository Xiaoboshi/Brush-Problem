class Solution {
    int deep = 0;
    public boolean dfs(Map<Integer, ArrayList<Integer>> map, int[] record, int num) {
        if (record[num] == 1) return false;
        if (record[num] == -1) return true;
        
        record[num] = 1;
        ArrayList<Integer> temp = map.get(num);
        if (temp != null) {
            for (int i = 0; i < temp.size(); i++) {
                if (!dfs(map, record, temp.get(i))){
                    return false;
                }
            }
        }
        record[num] = -1;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] record = new int[numCourses];
        Map<Integer, ArrayList<Integer>> map = new HashMap();


        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> temp;
            if (map.containsKey(prerequisites[i][1])) {
                temp = map.get(prerequisites[i][1]);
            } else {
                temp = new ArrayList();
            }
            temp.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], temp);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, record, i)) {
                return false;
            }
        }
        return true;
    }
}