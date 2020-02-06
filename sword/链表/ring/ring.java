/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

import java.util.ArrayList;

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null)
            return null;
        
        ListNode p = pHead;
        ListNode p2 = null;
        ArrayList<ListNode> a = new ArrayList<ListNode>();
        while(p != null) {
            for (int i = 0; i < a.size(); i++) {
                p2 = a.get(i);
                if (p2 == p)
                    return p;
            }
            a.add(p);
            p = p.next;
        }
        return null;
    }
}
