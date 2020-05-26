/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    
    public boolean dec(Map<Integer, Integer> m) {
        int k = 0;
        for (int x : m.keySet()) {
            if (m.get(x) % 2 != 0) {
                k++;
            }
        }
        return (k <= 1);
    }
    
    public void dfs(TreeNode root, Map<Integer, Integer> l) {
        if (root == null) {
            return;
        }
        l.put(root.val, l.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null) {
            if (dec(l))
                count++;
        }
        dfs(root.left, l);      
        dfs(root.right, l);
        l.put(root.val, l.get(root.val) - 1);
        if (l.get(root.val) == 0)
            l.remove(root.val);
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new HashMap());
        return count;
    }
}