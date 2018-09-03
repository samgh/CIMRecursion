class Decode:
	def decode(self,s):
		"""
		:type s: string
		:rtype: List[string]
		"""
		result = []
		# we are going to use an empty array and join it together, acting in place of StringBuilder
		self.decode_helper(s, 0, [], result)
		return result

	def decode_helper(self, s, i, curr, result):
		"""
		:type s: string
		:type i: int
		:type curr: List[string]
		:type result: List[string]
		:rtype: void
		"""
		if i >= len(s):
			result.append(''.join(curr))
			return

		for c in self.get_next(s,i):
			curr.append(c)
			if ord(c) < ord('A') + 10:
				self.decode_helper(s, i + 1, curr, result)
			else:
				self.decode_helper(s, i + 2, curr, result)
			del curr[-1]

	def get_next(self, s, i):
		"""
		:type s: string
		:type i: int
		:rtype: List[string]
		"""
		to_return = []
		val = int(s[i:i+1])
		to_return.append(chr(ord('A') + val - 1))

		if i < len(s)-1:
			val = int(s[i:i+2])
			if val <= 26:
				to_return.append(chr(ord('A') + val - 1))
		return to_return

test = Decode()
print(test.decode("223"))
print(test.decode("227"))
print(test.decode("4231123"))