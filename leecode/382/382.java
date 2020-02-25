/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    ListNode listn = null;
    int n = 0;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        listn = head;
        while(listn != null) {
            listn = listn.next;
            n++;
        }
        listn = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {

        int k = (int) (Math.random() * (n));
        ListNode listcp = listn;

        while(k > 0) {
            listcp = listcp.next;
            k--;
        }

        return listcp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
