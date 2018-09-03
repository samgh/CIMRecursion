class Iteration:
	def print_forward_iterative(self, arr):
		"""
		:type arr: List[int]
		:rtype: void
		"""
		for i in range(len(arr)):
			print(arr[i])

	def print_forward(self, arr):
		"""
		:type arr: List[int]
		:rtype: void
		"""
		self.print_forward_helper(arr, 0)

	def print_forward_helper(self, arr, i):
		"""
		:type arr: List[int]
		:type i: int
		:rtype: void
		"""
		if i == len(arr):
			return
		print(arr[i])
		self.print_forward_helper(arr, i + 1)

	def print_backward_iterative(self, arr):
		"""
		:type arr: List[int]
		:rtype: void
		"""
		for i in range(len(arr)-1, -1, -1):
			print(arr[i])

	def print_backward(self, arr):
		"""
		:type arr: List[int]
		:rtype: void
		"""
		self.print_backward_helper(arr, 0)

	def print_backward_helper(self, arr, i):
		"""
		:type arr: List[int]
		:type i: int
		:rtype: void
		"""
		if i == len(arr):
			return
		self.print_backward_helper(arr, i + 1)
		print(arr[i])

test = Iteration()
arr = [1,2,3,4,5]
test.print_forward_iterative(arr)
test.print_forward(arr)

test.print_backward_iterative(arr)
test.print_backward(arr)