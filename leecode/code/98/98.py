# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:


    def isValidBST(self, root: TreeNode) -> bool:
        
        def helper(root, lower = float("inf"), upper = float("inf")):
            if root == None:
                return True
            if lower != float("inf") and root.val <= lower :
                return False
            if upper != float("inf") and root.val >= upper:
                return False


            if not helper(root.left, lower, float(root.val)):
                return False
            if not helper(root.right, float(root.val), upper):
                return False
            return True


        return helper( root)