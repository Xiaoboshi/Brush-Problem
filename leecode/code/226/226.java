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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode releft = root.left;
        TreeNode reright = root.right;


        root.left = invertTree(reright);
        root.right = invertTree(releft);


        return root;
    }
}