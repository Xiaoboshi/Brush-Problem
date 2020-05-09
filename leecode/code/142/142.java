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
    public ListNode detectCycle(ListNode head) {
        ListNode rabit = head;
        ListNode tur = head;
        if (rabit == null)
            return null;


        do {
            if (rabit.next == null) {
                return null;
            } else {
                if (rabit.next.next == null) {
                    return null;
                } else {
                    rabit = rabit.next.next;
                }
            }
            if (tur.next == null) {
                return null;
            } else {
                tur = tur.next;
            }
        } while (tur != rabit);


        if (rabit == null) {
            return null;
        }


        tur = head;
        while (tur != rabit) {
            tur = tur.next;
            rabit = rabit.next;
        }
        return rabit;
    }
}