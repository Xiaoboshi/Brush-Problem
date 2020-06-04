# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True


        def helper(left, right):
            if left == None and right == None:
                return True
            
            if left == None or right == None:
                return False
            
            if left.val != right.val:
                return False
            
            return helper(left.left, right.right) and helper(left.right, right.left)
        
        return helper(root.left, root.right)

