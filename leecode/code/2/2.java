/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode last = l1;
        int temp = 0;
        while (h1 != null || h2 != null) {
            if (h1 != null && h2 != null) {
                int k = h1.val + h2.val + temp;
                if (k >= 10) {
                    temp = 1;
                    k %= 10;
                } else {
                    temp = 0;
                }
                h1.val = k;
                last = h1;
                h1 = h1.next;
                h2 = h2.next;
            } else if (h2 == null) {
                while(h1 != null) {
                    int k = h1.val + temp;
                    if (k >= 10) {
                        temp = 1;
                        k %= 10;
                    } else {
                        temp = 0;
                    }
                    h1.val = k;
                    last = h1;
                    h1 = h1.next;
                }
            } else if (h1 == null) {
                last.next = h2;
                h1 = last.next;
                h2 = null;
            }
        }
        if (temp != 0) {
            ListNode p = new ListNode(temp);
            last.next = p;
        }
        return l1;
    }
}