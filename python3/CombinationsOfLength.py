class CombinationsOfLength():
	def combinations_of_length_brute_force(self, n, length):
		# the below method is from Combinations.py file
		all_combinations = Cominations.combinations_built_up(n)
		filtered = []
		for l in all_combinations:
			if len(l) == length:
				filtered.append(l)
		return filtered

	def combinations_of_length_backtracking(self, n, length):
		return self.combinations_of_length_backtracking_helper(n, 0, length, 0)

	def combinations_of_length_backtracking_helper(self, n, i, target_length, current_length):
		if current_length > target_length:
			return []

		if i == len(n) and current_length != target_length:
			return []

		if i == len(n):
			to_return = []
			to_return.append([])
			return to_return

		include = self.combinations_of_length_backtracking_helper(n, i + 1, target_length, current_length + 1)
		exclude = self.combinations_of_length_backtracking_helper(n, i + 1, target_length, current_length)

		to_return = []

		for result in include:
			result.insert(0, n[i])
			to_return.append(result)

		to_return.extend(exclude)

		return to_return

test = CombinationsOfLength()
print(test.combinations_of_length_backtracking([1,2,3,4,5], 3))
