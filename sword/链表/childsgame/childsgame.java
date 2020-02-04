import java.util.ArrayList;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        int num = n;
        int temp = 0;
        int last = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        if (n <= 0 || m <= 0)
            return -1;
        
        for (int i = 0; i < n; i++)
            a.add(i);
        
        for (int i = 0; i < n - 1; i++) {
            temp = (temp + m - 1) % num;
            num--;
            last = a.remove(temp);
        }
        
        int b = a.get(0);
        
        return b;
        
    }
}
