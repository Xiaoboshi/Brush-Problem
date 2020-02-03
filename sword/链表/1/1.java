/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 1;
        int len2 = 1;
        int count = 2;
        
        ListNode p1, p2;
        ListNode last;
        p1 = pHead1;
        p2 = pHead2;
        
        if (p1 == null || p2 == null)
            return null;
        
        while (p1.next != null) {
            p1 = p1.next;
            len1++;
        }
        
        while (p2.next != null) {
            p2 = p2.next;
            len2++;
        }
        p1 = pHead1;
        p2 = pHead2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++)
                p1 = p1.next;
        }
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++)
                p2 = p2.next;
        }
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
