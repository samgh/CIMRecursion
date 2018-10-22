class Node:
	def __init__(self, val, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right

	def __repr__(self):
		return str(self.val)

class DFSTree():
	def contains(self, root, val):
		if not root:
			return False
		if root.val == val:
			return True
		return self.contains(root.left, val) or self.contain(root.right, val)

	def path_to_node(self, root, val):
		if not root:
			return None
		if root.val == val:
			to_return = []
			to_return.append(root)
			return to_return

		left = self.path_to_node(root.left, val)
		if left:
			left.insert(0, root)
			return left

		right = self.path_to_node(root.right, val)
		if right:
			right.insert(0, root)
			return right

		return None

test = DFSTree()
root = Node(1)
root.left = Node(2);
root.right = Node(3);
root.left.left = Node(4);
root.left.right = Node(5);
root.right.left = Node(6);
root.right.right = Node(7);
print(test.path_to_node(root, 7))
