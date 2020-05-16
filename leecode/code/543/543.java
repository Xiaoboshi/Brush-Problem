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


    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int templ = helper(root.left);
        int tempr = helper(root.right);
        return Math.max(templ, tempr) + 1;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;


        int temp1 = helper(root.left) + helper(root.right);
        int temp2 = diameterOfBinaryTree(root.left);
        int temp3 = diameterOfBinaryTree(root.right);


        return Math.max(temp1, Math.max(temp2, temp3));
    }
}