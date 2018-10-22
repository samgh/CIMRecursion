class GreatestProductPath():
    """
    Given an NxN matrix, find the path from (0,0) to (N-1, N-1) by moving either right or down that has the greatest product
    """
    def greatest_product_path(matrix):
    	return self.greatest_product_path_helper(matrix, 0, 0)

	def greatest_product_path_helper(matrix, i, j):
		if i == len(matrix)-1 and j == len(matrix[0] -1):
			return matrix[i][j]

		if i >= len(matrix) or j >= len(matrix[0]):
			return 0

		return matrix[i][j] * max(self.greatest_product_path_helper(matrix, i + 1, j), \
								  self.greatest_product_path_helper(matrix, i, j+ 1))

	def greatest_product_path2(matrix):
		result = []
		result.append(-float('inf'))
		self.greatest_product_path2_helper(matrix, 0, 0, 1, result)
		return result[0]

	def greatest_product_path2_helper(matrix, i, j, product, result):
		if i >= len(matrix) or j >= len(matrix[0]):
			return

		product *= matrix[i][j]

		if i == len(matrix) - 1 and j == len(matrix[0]) - 1:
			if result[0] < product:
				result[0] = product
			return

		self.greatest_product_path2_helper(matrix, i + 1, j, product, result)
		self.greatest_product_path2_helper(matrix, i, j + 1, product, result)


	def greatest_product_path_built_up(matrix):
		return self.greatest_product_path_built_up_helper(matrix, 0, 0)[0]

	def greatest_product_path_built_up_helper(matrix, i, j):
		if i >= len(matrix) or j >= len(matrix[0]):
			return None

		right = self.greatest_product_path_built_up_helper(matrix, i + 1, j)
		down = self.greatest_product_path_built_up_helper(matrix, i, j + 1)

		if not right and not down:
			return (matrix[i][j], matrix[i][j])

		max_val = float('inf')
		min_val = -float('inf')

		if right:
			max_val = max(max_val, max(right[0] * matrix[i][j], \
										right[1] * matrix[i][j]))
			min_val = min(min_val, min(right[0] * matrix[i][j], \
										right[1] * matrix[i][j]))

		if down:
			max_val = max(max_val, max(down[0] * matrix[i][j], \
										down[1] * matrix[i][j]))
			min_val = min(min_val, min(down[0] * matrix[i][j], \
										down[1] * matrix[i][j]))

		return (max_val, min_val)
    
