public class Solution {
    
    private int cnt = 0;
    
    public void mergesort(int [] array, int start, int mid, int end) {
        
        int i = start; 
        int j = mid + 1;
        int [] temp = new int [end - start + 1];
        int k = 0;
        int l = start;
        
        while(i <= mid && j <= end) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else {
                cnt = (cnt + mid - i + 1) % 1000000007;
                temp[k++] = array[j++];
            }
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= end)
            temp[k++] = array[j++];
        
        k = 0;
        while (l <= end)
            array[l++] = temp[k++];
    }
    
    public void merge(int [] array, int start, int end) {
        if (start == end) {
            return ;
        }
        int mid = (start + end) / 2;
        merge(array, start, mid);
        merge(array, mid + 1, end);
        mergesort(array, start, mid, end);
    }
    
    public int InversePairs(int [] array) {
        int len = array.length;
        if (len <= 1)
            return 0;
        merge(array, 0, len - 1);
        return cnt;
    }
}
