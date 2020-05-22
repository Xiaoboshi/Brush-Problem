# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None


        k = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])


        k.left = self.buildTree(preorder[1:mid + 1], inorder[0:mid])
        k.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])


        return k