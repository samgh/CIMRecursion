class ArrayOfArrays:

	def array_of_arrays(self, arr):
		results = []
		self.array_of_arrays_helper(arr, 0, [], results)
		return results

	def array_of_arrays_helper(self, arr, i, path, results):
		if i == len(arr):
			results.append(path)
			return

		for j in arr[i]:
			path.append(j)
			self.array_of_arrays_helper(arr, i + 1, path[:], results)
			path.pop()

test = ArrayOfArrays()
a_of_a = [[1,2],[3],[4,5]]
print(test.array_of_arrays(a_of_a))
