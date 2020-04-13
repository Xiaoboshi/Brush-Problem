class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            int j = 0;
            for (j = 0; j < arr2.length; j++) {
                int temp = Math.max(arr1[i], arr2[j]) - Math.min(arr1[i], arr2[j]);
                if (temp <= d)
                    break;
            }
            if (j >= arr2.length)
                distance++;
        }
        return distance;
    }
}
