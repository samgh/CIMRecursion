class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class LowestCommonAncestor:
        
    def lowestCommonAncestor(self, root, n1, n2):
        if not root:
            return
        
        if root.val == n1.val or root.val == n2.val:
            return root
        
        left = self.lowestCommonAncestor(root.left, n1, n2)
        
        right = self.lowestCommonAncestor(root.right, n1, n2)
        
        if left and right:
            return root
        else:
            return left or right

root = TreeNode(1)
root.left = TreeNode(2)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right = TreeNode(3)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)

lca = LowestCommonAncestor()
print(lca.lowestCommonAncestor(root, root.left.left, root.left.right).val) # expected to be 2
print(lca.lowestCommonAncestor(root, root.left.left, root).val) # expected to be 1
print(lca.lowestCommonAncestor(root, root.left, root.right.right).val) # expected to be 1
