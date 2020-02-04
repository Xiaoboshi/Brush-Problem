public class Solution {
    
    public int sort(int [] numbers, int len) {
        int temp = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++)
                if (numbers[i] < numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
        }
        for (int i = 0; i < len; i++)
            if (numbers[i] == 0)
                count++;
        return count;
    }
    
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        
        int count = sort(numbers, len);
        boolean flag = true;
        int temp = 0;
        
        if (len == 0)
            flag = false;
        
        for (int i = 0; i < len - 1; i++){
            if (numbers[i + 1] == 0)
                break;
            temp = numbers[i] - numbers[i + 1];
            if (temp == 0) {
                flag = false;
                break;
            }
            if (temp > 1) {
                if (count == 0) {
                    flag = false;
                    break;
                }
                if (temp - 1 <= count)
                    count--;
                else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
