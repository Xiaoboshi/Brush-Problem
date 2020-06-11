class Solution {


    List<List<String>> res;
    List<List<Integer>> res2;
    int minl = 0;


    public boolean comparestr(String s1, String s2) {
        int dif = 0;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dif++;
            }
        }
        return dif == 1;
    }


    public void dfs(int[][] graph, int n, int end, int ind, List<Integer> l) {


        if (ind == end) {
            if (l.size() == minl) {
                List<Integer> temp = new ArrayList(l);
                res2.add(temp);
            } else if (l.size() < minl) {
                minl = l.size();
                res2.clear();
                List<Integer> temp = new ArrayList(l);
                res2.add(temp);
            }
            return;
        }


        if (l.size() >= minl) {
            return;
        }


        for (int i = 1; i < n ; i++) {
            if (graph[ind][i] == 1 && !l.contains(i)) {
                l.add(i);
                dfs(graph, n, end, i, l);
                l.remove(l.size() - 1);
            }
        }
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int end = -1;
        res = new ArrayList();
        res2 = new ArrayList();
        Map<Integer, String> map = new HashMap();
        map.put(0, beginWord);
        for (int i = 1; i <= n; i++) {
            if (!wordList.get(i - 1).equals(beginWord)) {
                map.put(i, wordList.get(i - 1));
                if (wordList.get(i - 1).equals(endWord))
                    end = i;
            } else {
                wordList.remove(i - 1);
                i--;
                n--;
            }
        }


        if (end == -1) {
            return res;
        }
        
        n = map.size();
        minl = n + 1;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (comparestr(map.get(i), map.get(j))) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }


        List<Integer> l = new ArrayList();
        l.add(0);
        // 时间超时
        // dfs(graph, n, end, 0, l);


        // 采用bfs
        Queue<List<Integer>> q = new LinkedList();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        List<Integer> temp = new ArrayList();
        temp.add(0);
        q.add(temp);
        cost[0] = 0;


        while (!q.isEmpty()) {
            List<Integer> noww = q.poll();
            int lastt = noww.get(noww.size() - 1);


            if (lastt == end) {
                List<Integer> tmp = new ArrayList(noww);
                res2.add(tmp);
            } else {
                for (int i = 0; i < graph[lastt].length; i++) {
                    if (graph[lastt][i] == 1 && cost[lastt] + 1 <= cost[i]) {
                        cost[i] = cost[lastt] + 1;
                        List<Integer> tmp = new ArrayList(noww);
                        tmp.add(i);
                        q.add(tmp);
                    }
                }
            }
        }



        for (int i = 0; i < res2.size(); i++) {
            List<Integer> tempp = res2.get(i);
            List<String> temps = new ArrayList();
            for (int j = 0; j < tempp.size(); j++) {
                temps.add(map.get(tempp.get(j)));
            }
            res.add(temps);
        }
        return res;
    }
}