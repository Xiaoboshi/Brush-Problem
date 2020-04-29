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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode templ = root.left;
        TreeNode tempr = root.right;

        root.left = null;
        root.right = templ;
        flatten(templ);
        while (root.right != null) {
            root= root.right;
        }
        root.right = tempr;
        flatten(tempr);
    }
}