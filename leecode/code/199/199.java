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
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<TreeNode> a = new ArrayList();
        List<Integer> result = new ArrayList();
        a.add(root);
        int count = 1;
        while (root != null && a.size() != 0) {
            TreeNode tr = a.remove(0);
            count--;
            if (tr.left != null) {
                a.add(tr.left);
            }
            if (tr.right != null) {
                a.add(tr.right);
            }
            if (count == 0) {
                result.add(tr.val);
                count = a.size();
            }
        }
        return result;
    }
}