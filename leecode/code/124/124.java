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

    int max_sum = Integer.MIN_VALUE;

    public int getsum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(getsum(root.left), 0);
        int right = Math.max(getsum(root.right), 0);
        int now = root.val + left + right;

        max_sum = Math.max(now, max_sum);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        getsum(root);
        return max_sum;
    }
}
