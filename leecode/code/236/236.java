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
    
    public boolean dfs(TreeNode root, TreeNode p, List<TreeNode> k) {        
        if (p.val == root.val) {
            k.add(root);
            return true;
        }
        boolean found = false;
        k.add(root);
        if (root.left != null) {
            found = dfs(root.left, p, k);
        }
        if (!found && root.right != null) {
            found = dfs(root.right, p, k);
        }
        if (!found) {
            k.remove(k.size() - 1);
        }
        return found;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> k = new ArrayList();
        dfs(root, p, k);
        List<TreeNode> k2 = new ArrayList();
        dfs(root, q, k2);
        int lenk = k.size();
        int lenk2 = k2.size();
        for (int i = lenk - 1; i >= 0; i--) {
            for (int j = lenk2 - 1; j >= 0; j--) {
                if (k.get(i).val == k2.get(j).val) {
                    return k.get(i);
                }
            }
        }
        return root;
    }
}