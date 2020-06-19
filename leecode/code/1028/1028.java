/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() <= 0)
            return null;
        Stack<TreeNode> st = new Stack();
        int i = 0;
        int toorv = 0;
        while (i < S.length() && S.charAt(i) != '-') {
            toorv = toorv * 10 + (S.charAt(i) - '0');
            i++;
        }
        TreeNode res = new TreeNode(toorv);
        res.left = null;
        res.right = null;
        st.push(res);
        for (; i < S.length(); i++) {
            int count = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                count++;
                i++;
            }
            int temp = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                temp = temp * 10 + (S.charAt(i) - '0');
                i++;
            }


            TreeNode tempp = new TreeNode(temp);
            tempp.left = null;
            tempp.right = null;
            while (!st.isEmpty() && count < st.size() - 1) {
                st.pop();
            }


            if (st.peek().left == null) {
                st.peek().left = tempp;
            } else {
                st.peek().right = tempp;
            }
            st.push(tempp);
        }
        return res;
    }
}