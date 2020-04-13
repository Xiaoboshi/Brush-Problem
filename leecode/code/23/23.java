/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> a = new ArrayList();

        for (int i = 0; i < lists.length; i++) {
            ListNode point = lists[i];
            while(point != null) {
                a.add(point.val);
                point = point.next;
            }
        }
        Collections.sort(a);
        if (a.size() == 0) {
            return null;
        }

        ListNode head = new ListNode(a.get(0));
        ListNode result = head;

        for (int i = 1; i < a.size(); i++) {
            ListNode aa = new ListNode(a.get(i));
            head.next = aa;
            head = head.next;
        }

        return result;
    }
}
