# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def dfs(self, root, level, res):
        if not root: 
            return
        if len(res) == level:
            res.append([])
        res[level].append(root.val)
        if root.left != None:
            self.dfs(root.left, level + 1, res)
        if root.right != None:
            self.dfs(root.right, level + 1, res)



    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.dfs(root, 0, res)
        return res

