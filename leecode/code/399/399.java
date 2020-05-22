class Solution {


    Map<String, Integer> map;
    Map<String, Integer> nummap;
    double[][] calmap;


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        int count = 0;
        map = new HashMap();
        nummap = new HashMap();
        for (int i = 0; i < equations.size(); i++) {
            String temp = equations.get(i).get(0);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (!nummap.containsKey(temp))
                nummap.put(temp, count++);
            temp = equations.get(i).get(1);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (!nummap.containsKey(temp))
                nummap.put(temp, count++);
        }


        calmap = new double[map.size()][map.size()];
        for (int i = 0; i < map.size(); i++)
            Arrays.fill(calmap[i], -1.0);
        for (int i = 0; i < equations.size(); i++) {
            int left = nummap.get(equations.get(i).get(0));
            int right = nummap.get(equations.get(i).get(1));
            calmap[left][right] = values[i];
            calmap[right][left] = 1 / values[i];
        }


        for (int i = 0; i < queries.size(); i++)
            res[i] = calres(queries.get(i));


        return res;
    }


    public double calres(List<String> querie) {
        String left = querie.get(0);
        String right = querie.get(1);
        if (!nummap.containsKey(left) || !nummap.containsKey(right)) 
            return -1.0;
        else if (left.equals(right))
            return 1.0;
        else {
            int leftnum = nummap.get(left);
            int rightnum = nummap.get(right);
            if (calmap[leftnum][rightnum] != -1)
                return calmap[leftnum][rightnum];
            
            int[] record = new int[map.size()];
            double k = dfs(leftnum, rightnum, record);
            if (k > 0)
                return k;
            else
                return -1.0;
        }
    }


    public double dfs(int next, int target, int[] record) {
        if (next == target)
            return 1.0;
        else {
            record[next] = 1;
            for (int i = 0; i < map.size(); i++) {
                if (i != next && calmap[next][i] > 0 && record[i] != 1) {
                    record[i] = 1;
                    double temp = dfs(i, target, record);
                    if (temp > 0)
                        return temp * calmap[next][i];
                    record[i] = 0;
                }
            }
            return -1;
        }
    }
}