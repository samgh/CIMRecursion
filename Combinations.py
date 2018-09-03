class Combinations:

	def combinations_global(self,n):
		"""
		:type n:List[int]
		:rtype: void
		"""
		self.results = []
		self.combinations_global_helper(n, 0, [])
		print(self.results)

	def combinations_global_helper(self, n, i, path):
		"""
		:type n:List[int]
		:type i: int
		:type path: List[int]
		:rtype: void
		"""
		if i == len(n):
			self.results.append(path)
			return

		path_with_current = path[:]
		path_with_current.append(n[i])

		# Find all the combinations that exclude current item
		self.combinations_global_helper(n, i+1, path)

		# Find all the combinations that include current item
		self.combinations_global_helper(n, i+1, path_with_current)

	def combinations_passed(self, n):
		"""
		:type n: List[int]
		:rtype: List[List[int]]
		"""
		results = []
		self.combinations_passed_helper(n, 0, results, [])
		return results

	def combinations_passed_helper(self, n, i, results, path):
		"""
		:type n:List[int]
		:type i: int
		:type results: List[List[int]]
		:type path: List[int]
		:rtype: void
		"""
		if i == len(n):
			results.append(path)
			return

		path_with_current = path[:]
		path_with_current.append(n[i])

		# Find all the combinations that exclude current item
		self.combinations_passed_helper(n, i+1, results, path)

		# Find all the combinations that include current item
		self.combinations_passed_helper(n, i+1, results, path_with_current)

	def combinations_built_up(self, n):
		"""
		:type n: List[int]
		:rtype: List[List[int]]
		"""
		return self.combinations_built_up_helper(n, 0)

	def combinations_built_up_helper(self, n, i):
		"""
		:type n:List[int]
		:type i: int
		:rtype: List[List[int]]
		"""
		if i == len(n):
			to_return = []
			to_return.append([])
			return to_return

		to_return = []
		for result in self.combinations_built_up_helper(n, i+1):
			# Exclude current item
			to_return.append(result)

			# Include current item
			result = [n[i]] + result
			to_return.append(result)

		return to_return

test = Combinations()
combinations = [1,2,3]
test.combinations_global(combinations)
print(test.combinations_passed(combinations))
print(test.combinations_built_up(combinations))