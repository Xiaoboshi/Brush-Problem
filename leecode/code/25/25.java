/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode left = head;
        ListNode right = p;
        ListNode res = p;


        while (right != null || k != 1) {
            int i = 0;
            while (right != null && i < k) {
                right = right.next;
                i++;
            }
            if (right == null) {
                if (left != null) {
                    p.next = left;
                }
                break;
            }
            ListNode m = right.next;
            ListNode op = new ListNode(0);
            op.next = null;
            ListNode o = left;
            i = 0;
            while (i < k) {
                p.next = left;
                left = left.next;
                p.next.next = op;
                op = p.next;
                i++;
            }
            o.next = m;
            p = o;
            right = p;
            left = m;
        }
        return res.next;
    }
}