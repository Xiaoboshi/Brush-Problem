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


    public TreeNode convertBST(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> s = new Stack();
        int res = 0;        
        while (true) {
            while (p != null) {
                s.push(p);
                p = p.right;
            }
            
            if (s.isEmpty()) {
                break;
            }
            TreeNode k = s.pop();
            k.val += res;
            res = k.val;
            if (k.left != null) {
                p = k.left;
            }
        }
        return root;
    }
}