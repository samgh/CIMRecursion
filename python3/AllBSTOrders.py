class Node:
	def __init__(self):
		self.val = None
		self.left = None
		self.right = None

class ALLBSTOrders:

	def all_BST_orders_DC(self, root):
		if not root:
			to_return = []
			to_return.append([])
			return to_return

		left = self.all_BST_orders_DC(root.left)
		right = self.all_BST_orders_DC(root.right)

		merged = self.merge_all(left, right)

		for l in merged:
			l.insert(0, root.val)

		return merged

	def merge_all(self, first, second):
		result = []
		for f in first:
			for s in second:
				self.merge(f,s, 0,0, [], result)
		return result

	def merge(self, first, second, i, j, path, result):
		if i == len(first) and j == len(second):
			result.append(path)
			return

		if i != len(first):
			path.append(first[i])
			self.merge(first, second, i + 1, j, path[:], result)
			path.pop()

		if j != len(second):
			path.append(second[j])
			self.merge(first, second, i, j + 1, path[:], result)
			path.pop()

	def all_bst_orders_ordering(self, root):
		results = []
		self.all_bst_orders_ordering_helper(set([root]), [], results)
		return results

	def all_bst_orders_ordering_helper(self, available, path, results):
		if not available:
			results.append(path)
			return

		for n in available:
			available.remove(n)
			if n.left:
				available.add(n.left)
			if n.right:
				available.add(n.right)
			path.append(n.val)

			self.all_bst_orders_ordering_helper(available, path[:], results)

			path.pop()
			if n.left:
				available.remove(n.left)
			if n.right:
				available.remove(n.right)
			available.add(n)

test = ALLBSTOrders()
root = Node()
root.val = 5
root.left = Node()
root.left.val = 3
root.right = Node()
root.right.val = 8
root.left.left = Node()
root.left.left.val = 2
root.left.right = Node()
root.left.right.val = 4
print(test.all_BST_orders_DC(root))
print(test.all_bst_orders_ordering(root))
