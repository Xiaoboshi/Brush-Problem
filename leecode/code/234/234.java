/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public ListNode reverse(ListNode head) {
        ListNode p = null;
        ListNode cur = head;
        ListNode k = cur.next;


        while (cur != null) {
            k = cur.next;
            cur.next = p;
            p = cur;
            cur = k;
        }
        return p;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode re = reverse(slow);
        while (re != null) {
            if (head.val != re.val) {
                return false;
            }
            re = re.next;
            head = head.next;
        }
        return true;
    }
}