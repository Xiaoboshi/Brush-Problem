class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int len = houses.length;
        int warmnum = heaters.length;
        int [] record = new int[len];

        Arrays.sort(houses);
        Arrays.sort(heaters);

        for (int i = 0; i < len; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < warmnum; j++) {
                count = Math.min(count, 
                        Math.max(houses[i], heaters[j]) - Math.min(houses[i], heaters[j]));
            }
            record[i] = count;
        }
        Arrays.sort(record);

        return record[len - 1];
    }
}
