class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char x : tasks) map[x - 'A']++;
        Arrays.sort(map);
        int res = map[25] * n - n;


        for (int i = 24; i >= 0 && map[i] > 0; i--)
            res -= Math.min(map[i], map[25] - 1);
        
        return (res > 0)? res + tasks.length: tasks.length;


        
    }
}