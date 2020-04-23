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

    public boolean vall(TreeNode root, Integer lower, Integer higher) {
        if (root == null)
            return true;

        int temp = root.val;

        if (lower != null && temp <= lower) return false;
        if (higher != null && temp >= higher) return false;

        if (!vall(root.left, lower, temp)) return false;
        if (!vall(root.right, temp, higher)) return false;
        return true;

    }

    public boolean isValidBST(TreeNode root) {
        return vall(root, null, null);

    }
}