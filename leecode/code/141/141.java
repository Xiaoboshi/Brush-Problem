/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;


        do {
            if (fast.next != null) {
                fast = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            slow = slow.next;
        } while(fast != slow);


        if (fast != null)
            return true;
        return false;
    }
}