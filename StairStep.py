class StairStep:
	def stair_step_count(self, n):
		"""
		:type n: int
		:rtype: int
		"""
		if n == 0:
			return 1
		if n < 0:
			return 0

		return self.stair_step_count(n-1)+self.stair_step_count(n-2)+self.stair_step_count(n-3)

	#  figure out a way to cut down on the duplication!
	def stair_step(self, n):
		"""
		:type n: int
		:rtype: List[List[int]
		"""
		if n == 0:
			result = []
			result.append([])
			return result
		if n < 0:
			return []

		result = self.stair_step(n-1)
		result.extend(self.stair_step(n-2))
		result.extend(self.stair_step(n-3))

		for l in result:
			l.append(n)

		return result

test = StairStep()
print(test.stair_step(3))
print(test.stair_step(5))