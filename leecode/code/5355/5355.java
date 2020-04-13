class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        int len = edges.length;
        int tetar = target;
        int count = 0;
        double p = 1.0;
        
        int [] record = new int[n];
        int [] path = new int[len];
        
        int tempp = 0;
        for (int i = 0; i < len; i++) {
            if (edges[i][0] > edges[i][1]) {
                tempp = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = tempp;
            }
        }
        
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) return a1[1] - a2[1];
                else return a1[0] - a2[0];
            }
        });
        
        for (int i = 0; i < len; i++) {
            record[edges[i][0] - 1] ++;
        }
        
        while(tetar != 1 && count < len) {
            for (int i = 0; i < len; i++) {
                if (edges[i][1] == tetar) {
                    tetar = edges[i][0];
                    break;
                }
            }
            path[count] = tetar;
            count++;
        }
        
        if (count == t) {
            for (int i = count - 1; i >= 0; i--) {
                int order = path[i] - 1;
                p *= 1.0 / record[order]; 
            }
            return p;
        } else if (count < t) {
            if (record[target - 1] != 0)
                return 0.0;
            else {
                for (int i = count - 1; i >= 0; i--) {
                    int order = path[i] - 1;
                    p *= 1.0 / record[order]; 
                }
                return p;
            }
        } else
            return 0.0;
    }
}
