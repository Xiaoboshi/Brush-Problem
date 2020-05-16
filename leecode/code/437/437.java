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


    int count = 0;
    public void dfs(TreeNode root, int sum) {
        if (root == null)
            return;
        if (sum - root.val == 0) {
            count++;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }
}