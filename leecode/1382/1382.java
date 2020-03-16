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
    ArrayList<Integer> a = new ArrayList<Integer>();

    public void getnum(TreeNode root) {
        if (root == null) {
            return;
        }
        getnum(root.left);
        a.add(root.val);
        getnum(root.right);
    }

    public TreeNode buildTree(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (r - l) / 2 + l;
        TreeNode root = new TreeNode(a.get(mid));
        root.left = buildTree(l, mid - 1);
        root.right = buildTree(mid + 1, r);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        getnum(root);
        int count = a.size();
        TreeNode root2 = buildTree(0, a.size() - 1);
        return root2;
    }
}
