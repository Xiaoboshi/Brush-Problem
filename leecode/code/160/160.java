/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> p1 = new Stack();
        Stack<ListNode> p2 = new Stack();
        while (headA != null) {
            p1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            p2.push(headB);
            headB = headB.next;
        }
        if (p1.isEmpty() || p2.isEmpty() || p1.peek() != p2.peek()) {
            return null;
        }
        int flag = 0;
        ListNode temp = p1.pop();
        ListNode temp2 = p2.pop();
   
        while (!p1.isEmpty() && !p2.isEmpty()) {
            if (p1.peek() != p2.peek()) {
                return temp;
            }
            temp = p1.pop();
            temp2 = p2.pop();
        }
        return temp;
    }
}