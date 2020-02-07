/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

import java.util.ArrayList;
public class Solution {
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        if (pRoot.left == null && pRoot.right == null)
            return true;
        
        int a1 = 0;
        int b1 = 0;
        int count = 1;
        boolean flag = true;
        TreeNode p1 = pRoot.left;
        TreeNode p2 = pRoot.right;
        ArrayList<TreeNode> a = new ArrayList<TreeNode>();
        ArrayList<TreeNode> b = new ArrayList<TreeNode>();
        
        a.add(p1);
        b.add(p2);
        
        while(a.size() != 0 && b.size() != 0) {
            p1 = a.remove(0);
            p2 = b.remove(0);
            count--;
            if (p1.val == p2.val) {
                if (p1.left != null && p2.right != null) {
                    a.add(p1.left);
                    b.add(p2.right);
                } else if (p1.left == null && p2.right == null){
                    continue;
                } else{
                    return false;
                }
                if (p1.right != null && p2.left != null) {
                    a.add(p1.right);
                    b.add(p2.left);
                } else if (p1.right == null && p2.left == null){
                    continue;
                } else{
                    return false;
                }
                if (a.size() != b.size())
                    return false;
                else
                    if (count == 0)
                        count = a.size();
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
