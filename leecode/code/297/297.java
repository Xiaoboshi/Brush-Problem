/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string. 
    public String serialize(TreeNode root) {
        String result = "";
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> a = new ArrayList();
        a.add(root);
        result = result + String.valueOf(root.val);
        result = result + ",";

        while (a.size() > 0) {
            TreeNode tr = a.remove(0);
            if (tr.left != null) {
                a.add(tr.left);
                result = result + String.valueOf(tr.left.val);
                result = result + ",";
            } else {
                result = result + "null,";
            }
            
            if (tr.right != null) {
                a.add(tr.right);
                result = result + String.valueOf(tr.right.val);
                result = result + ",";
            } else {
                result = result + "null,";
            }
        }
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] s = data.split(",");
        if (s.length == 0 || s[0].equals("null") || s[0].equals("")) {
            return null;
        } else {
            TreeNode head = new TreeNode(Integer.valueOf(s[0]));
            TreeNode result = head;
            ArrayList<TreeNode> relist = new ArrayList();
            relist.add(head);
            
            int k = 0;
            while (relist.size() > 0 && k < s.length) {
                TreeNode tr = relist.remove(0);
                if (s[k + 1].equals("null")) {
                    tr.left = null;
                } else {
                    TreeNode temp = new TreeNode(Integer.valueOf(s[k + 1]));
                    tr.left = temp;
                    relist.add(temp);
                }

                if (s[k + 2].equals("null")) {
                    tr.right = null;
                } else {
                    TreeNode temp2 = new TreeNode(Integer.valueOf(s[k + 2]));
                    tr.right = temp2;
                    relist.add(temp2);
                }
                k += 2;
            }
            return result;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));