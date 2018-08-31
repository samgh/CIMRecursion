class InsertAtBottom:
	def insert_at_bottom_iterative(self, s, i):
		"""
		:type s: List[int]
		:type i: int
		:rtype: void
		"""
		temp = []
		while s:
			temp.append(s.pop())
		s.append(i)
		while temp:
			s.append(temp.pop())

	def insert_at_bottom_recursive(self, s, i):
		"""
		:type s: List[int]
		:type i: int
		:rtype: void
		"""
		if not s:
			s.append(i)
			return

		top = s.pop()
		self.insert_at_bottom_recursive(s, i)
		s.append(top)

test = InsertAtBottom()
stack = [1,2,3,4]
test.insert_at_bottom_iterative(stack, 5)
print(stack)
test.insert_at_bottom_recursive(stack, 6)
print(stack)