class Solution {

    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    public int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y : graph.get(x)) {
                if (count.get(y) != 0)
                    ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }

    public int numSquarefulPerms(int[] A) {
        int ans = 0;
        // 初始化数量以及图
        for (int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int x : count.keySet()) {
            graph.put(x, new ArrayList());
        }

        for (int x : count.keySet()) {
            for (int y : count.keySet()) {
                int r = (int)(Math.sqrt(x + y) + 0.5);
                if (r * r == (x + y)) {
                    graph.get(x).add(y);
                }
            }
        }
        // dfs
        for (int x : count.keySet()) {
            ans += dfs(x, A.length - 1);
        }
        return ans;
    }
}
