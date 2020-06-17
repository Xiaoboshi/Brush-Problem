# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Codec:


    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            return "null,"
        
        def dfs(root):
            if root == None:
                return "null,"
            
            res = ""
            res += str(root.val) + ','
            res += dfs(root.left)
            res += dfs(root.right)
            
            return res
        
        return dfs(root)[:-1]



    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """


        ms = data.split(',')
        
        def dff(ms, ind):
            if ind >= len(ms):
                return None, ind + 1


            if ms[ind] == 'null':
                return None, ind + 1
            
            root = TreeNode()
            root.val = int(ms[ind])
            ind += 1
            root.left, ind = dff(ms, ind)
            root.right, ind = dff(ms, ind)
            
            return root, ind
        
        root, ind = dff(ms, 0)
        return root
        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))