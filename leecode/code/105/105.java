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


    public int findnum(int[] nums, int start, int end, int target) {
        for (; start <= end; start++) {
            if (nums[start] == target) {
                return start;
            }
        }
        return start;
    }


    public TreeNode helper(int[] preorder, int[] inorder, int pl, int pr, int ol, int or) {
        if (pl > pr || ol > or) {
            return null;
        }


        TreeNode root = new TreeNode(preorder[pl]);
        int mid = findnum(inorder, ol, or, preorder[pl]);
            root.left = helper(preorder, inorder, pl + 1, pl + mid - ol, ol, mid - 1);
            root.right = helper(preorder, inorder, pl + mid - ol + 1, pr, mid + 1, or);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = helper(preorder, inorder,
                                 0, preorder.length - 1, 0, inorder.length - 1);
       
        return root;
    }
}