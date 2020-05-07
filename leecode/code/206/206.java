/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        ListNode temp = head.next;
        ListNode tempp = head;
        ListNode temppp = head;
        while (temp != null) {
            ListNode fg = temp.next;
            temp.next = temppp;
            res = temp;
            temppp = temp;
            tempp.next = fg;
            temp = tempp.next;
        }
        return res;
    }
}