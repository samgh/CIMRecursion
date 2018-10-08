class LongestIncreasingSubsequence:
    def longest_increasing_subsequence(self, l):
        return self.longest_increasing_subsequence_helper(l, 0, 0)

    def longest_increasing_subsequence_helper(self, arr, i, curr_min):
        if i == len(arr):
            return []

        max_list = self.longest_increasing_subsequence_helper(arr, i + 1, curr_min)
        
        if arr[i] > curr_min:
            includeI = self.longest_increasing_subsequence_helper(arr, i + 1, arr[i])
            includeI.insert(0, arr[i])
            if len(includeI) > len(max_list):
                max_list =includeI
        
        return max_list

test = LongestIncreasingSubsequence()
l = [9,6,1,5,3,7,55,12]
print("Result: ",test.longest_increasing_subsequence(l))
