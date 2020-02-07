import java.util.Set;
import java.util.Map;

public class Solution {
    
    String a = "";
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        a += ch;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int len = a.length();
        
        if (len <= 0)
            return '#';
        
        String temp = "";
        int [] lens = new int[len];
        int count = 0;
        int count1 = 0;
        
        for (int i = 0; i < len; i++) {
            if (temp.length() == 0) {
                temp += a.charAt(i);
                lens[count]++;
                count++;
            } else {
                if (temp.indexOf(a.charAt(i)) <= -1) {
                    temp += a.charAt(i);
                    lens[count]++;
                    count++;
                } else if (temp.indexOf(a.charAt(i)) < len){
                    count1 = temp.indexOf(a.charAt(i));
                    lens[count1] = lens[count1] + 1;
                }
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (lens[i] == 1) {
                count = i;
                break;
            }
        }
        
        if (temp.length() <= count)
            return '#';
        else
            return temp.charAt(count);
    }
}
