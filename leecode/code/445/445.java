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
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode result2 = new ListNode(0);
        int temp = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int tempk = s1.pop() + s2.pop() + temp;
            ListNode re = new ListNode(tempk % 10);
            re.next = result2.next;
            result2.next = re;
            temp = tempk / 10;
        }
        while (!s1.isEmpty()) {
            int tempk = s1.pop() + temp;
            ListNode re = new ListNode(tempk % 10);
            re.next = result2.next;
            result2.next = re;
            if (temp != 0) {
                temp = tempk / 10;
            }
        }
        while (!s2.isEmpty()) {
            int tempk = s2.pop() + temp;
            ListNode re = new ListNode(tempk % 10);
            re.next = result2.next;
            result2.next = re;
            if (temp != 0) {
                temp = tempk / 10;
            }
        }
        if (temp != 0) {
            ListNode re = new ListNode(temp);
            re.next = result2.next;
            result2.next = re;
        }
        return result2.next;
    }
}