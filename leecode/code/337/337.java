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
    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        int leftt = root.val;
        if (root.left != null)
            leftt += rob(root.left.left) + rob(root.left.right);
        
        int rightt = 0;
        if (root.right != null)
            leftt += rob(root.right.left) + rob(root.right.right);

        return Math.max(leftt + rightt, (rob(root.left) + rob(root.right)));
    }
}