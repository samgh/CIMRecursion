class IsPalindrome:
	def is_palindrome(self, s):
		"""
		:type s: string
		:rtype: boolean
		"""
		if len(s) <= 1:
			return True
		return s[0] == s[-1] and self.is_palindrome(s[1:-1])

test = IsPalindrome()
print(test.is_palindrome("abcba"))
print(test.is_palindrome("abccba"))
print(test.is_palindrome("abcdba"))
print(test.is_palindrome("abccbb"))
print(test.is_palindrome("a"))
print(test.is_palindrome(""))