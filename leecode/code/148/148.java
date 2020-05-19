/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int count = 0;
        ListNode k = head;
        while (k != null) {
            count++;
            k = k.next;
        }
        int intv = 1;
        ListNode res = new ListNode(0);
        res.next = head;
        while (intv < count) {
            ListNode pre = res;
            ListNode h = res.next;
            while (h != null) {
                ListNode h1 = h;
                int i = 0;
                for (i = 0; i < intv && h != null; i++) {h = h.next;}
                if (i < intv) break;
                ListNode h2 = h;
                for (i = 0; i < intv && h != null; i++) {h = h.next;}
                int len1 = intv;
                int len2 = i;


                while (len1 > 0 && len2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        len1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        len2--;
                    }
                    pre = pre.next;
                }
                pre.next = (len1 == 0)? h2 : h1;
                while (len1 > 0) {
                    pre = pre.next;
                    len1--;
                }
                while (len2 > 0) {
                    pre = pre.next;
                    len2--;
                }
                pre.next = h;
            }
            intv *= 2;
        }
        return res.next;
    }
}

