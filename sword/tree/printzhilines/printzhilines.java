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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
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
        
        int temp = 0;
        for(int i = 0; i < a.size(); i++) {
            if (i % 2 == 1) {
                int left = 0;
                int right = a.get(i).size() - 1;
                while(left < right) {
                    temp = a.get(i).get(left);
                    a.get(i).set(left, a.get(i).get(right));
                    a.get(i).set(right, temp);
                    left++;
                    right--;
                }
            }
        }
        return a;
    }
}
