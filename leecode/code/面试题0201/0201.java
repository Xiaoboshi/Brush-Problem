/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Map<Integer, Integer> map = new HashMap();
        ListNode whead = new ListNode(0);
        whead.next = head;
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p.val)) {
                ListNode tmp = p.next;
                whead.next = tmp;
                p.next = null;
                p = whead;
            } else {
                map.put(p.val, 0);
            }
            whead = p;
            p = p.next;
        }
        return head;
    }
}
