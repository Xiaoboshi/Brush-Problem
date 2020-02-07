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
    
    public int index = -1;
    
    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        else
            return String.valueOf(root.val) + '!' + Serialize(root.left) + '!'
            + Serialize(root.right);
    }
    
    TreeNode Deserialize(String str) {
        String [] a = str.split("!");
        index++;
        if (str.length() == 0)
            return null;
        
        if (index > str.length())
            return null;
        
        if (a[index].equals("#"))
            return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(a[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
            return root;
        }
    }

}
