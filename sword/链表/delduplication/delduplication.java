import java.util.ArrayList;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;
        
        ListNode last = pHead;
        ListNode p = pHead.next;
        
        int temp = pHead.val;
        int count = 1;
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        while (p != null) {
            if (temp == p.val) {
                count++;
            } else {
                a.add(count);
                count = 1;
                temp = p.val;
            }
            p = p.next;
        }
        if (count != 1)
            a.add(count);
        
        last = pHead;
        p = pHead;
        count = 0;
        
        while (count < a.size()) {
            if (a.get(count) == 1) {
                last = p;
                p = p.next;
            }
            else {
                temp = a.get(count);
                while (temp > 0) {
                    if (p != pHead) {
                        last.next = p.next;
                        p.next = null;
                        p = last.next;
                        temp--;
                    } else {
                        last = last.next;
                        p.next = null;
                        p = last;
                        pHead = p;
                        temp--;
                    }
                }
            }
            count++;
        }
        
        return pHead;
    }
}
