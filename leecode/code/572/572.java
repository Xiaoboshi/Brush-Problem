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


    public boolean dfs(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return dfs(s.left, t.left) && dfs(s.right, t.right);


    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}