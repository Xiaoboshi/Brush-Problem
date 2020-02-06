/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

import java.util.ArrayList;

public class Solution {
    ArrayList<TreeLinkNode> atree= new ArrayList<TreeLinkNode>();
    
    public void center(TreeLinkNode root) {
        if (root == null)
            return;
        center(root.left);
        atree.add(root);
        center(root.right);
    }
    
    
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;
        
        TreeLinkNode a = pNode;
        while (a.next != null) {
            a = a.next;
        }
        center(a);
        for (int i = 0; i < atree.size(); i++) {
            if (pNode == atree.get(i)){
                if (i + 1 < atree.size())
                    return atree.get(i + 1);
            }
        }
        return null;
    }
}
