/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        ListNode q = p.next;
        while (q != null && q.next != null) {
            ListNode temp = q.next;
            ListNode swap = q.next.next;
            p.next = temp;
            temp.next = q;
            q.next = swap;
            p = q;
            q = q.next;
        }
        return head.next;
    }
}