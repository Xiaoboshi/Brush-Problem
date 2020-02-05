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
import java.util.Stack;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        TreeNode p1 = pRoot;
        TreeNode p2 = pRoot;
        Stack<TreeNode> s = new Stack<TreeNode>();
        int count = 0;
        
        while(!s.empty() || p1 != null) {
            if (count >= k)
                break;
            else {
                while(p1 != null) {
                    s.push(p1);
                    p1 = p1.left;
                }
                if (!s.empty()) {
                    p1 = s.pop();
                    if (count == k - 1){
                        return p1;
                    }
                    count++;
                    p1 = p1.right;
                }
            }
        }        
        return null;
    }
}
