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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> record = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        record.add(root);
        List<Integer> k = new ArrayList();
        int count = 1;
        while (record.size() != 0 && root != null) {
            TreeNode temp = record.remove(0);
            k.add(temp.val);
            count--;
            if (temp.left != null) {
                record.add(temp.left);
            }
            if (temp.right != null) {
                record.add(temp.right);
            }
            if (count == 0) {
                res.add(k);
                count = record.size();
                k = new ArrayList();
            }
        }
        return res;
    }
}