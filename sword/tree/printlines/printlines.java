import java.util.ArrayList;


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
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        
        if (pRoot == null)
            return a;
        
        int count = 0;
        TreeNode p = null;
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<TreeNode> c = new ArrayList<TreeNode>();
        c.add(pRoot);
        
        while (pRoot != null && c.size() != 0) {
            p = c.remove(0);
            b.add(p.val);
            if (count == 0) {
                a.add(b);
                b = new ArrayList<Integer>();
                if (p.left != null)
                    c.add(p.left);
                if (p.right != null)
                    c.add(p.right);
                count = c.size() - 1;
            } else {
                if (p.left != null)
                    c.add(p.left);
                if (p.right != null)
                    c.add(p.right);
                count--;
            }
        }
        return a;
    
    }
    
}
