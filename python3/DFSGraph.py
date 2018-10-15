class Node():
    def __init__(self, val=None, neighbors=[]):
        self.val = val
        self.neighbors = []
        
class DFSGraph():

	def path_exists(self, src, dest):
		return self.path_exists_helper(src, dest, set())

	def path_exists_helper(self, curr, dest, visited):
		if curr in visited:
			return False
		if curr == dest:
			return True

		visited.add(curr)
		for n in curr.neighbors:
			if self.path_exists_helper(n, dest, visited):
				return True

		return False

	def paths(self, src, dest):
		results = []
		self.paths_helper(src, dest, set(), [], results)
		return results

	def paths_helper(self, curr, dest, visited, path, results):
		if curr in visited:
			return
		if curr == dest:
			path.append(curr)
			results.append([n.val for n in path])
			path.pop()
			return

		visited.add(curr)
		path.append(curr)
		for n in curr.neighbors:
			self.paths_helper(n, dest, visited, path[:], results)
		path.pop()
		visited.remove(curr)

test = DFSGraph()
graph = []
for i in range(6):
	node = Node(i)
	graph.append(node)

graph[0].neighbors = [graph[1], graph[2], graph[3]]
graph[1].neighbors = [graph[4], graph[1]]
graph[2].neighbors = [graph[2]]
graph[3].neighbors = [graph[1]]
graph[4].neighbors = [graph[1], graph[2], graph[3]]
graph[5].neighbors = []

print(test.paths(graph[0],graph[4]))
