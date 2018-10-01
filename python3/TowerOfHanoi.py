class POSITION:
    SRC, DEST, AUX = "SRC", "DEST", "AUX"
    
class Move:
    def __init__(self, disk, src, dest):
        """
        :type disk: int
        :type src: POSITION
        :type dest: POSITION
        :rtype: void
        """
        self.disk = disk
        self.src = src
        self.dest = dest
    
    def __str__(self):
        return "{0} from {1} to {2}".format(self.disk, self.src, self.dest)

class TowerOfHanoi(object):
    """Print out the moves it takes to move all disks from start to end position
    """
    def towers_of_hanoi(self, n):
        """
        :type n: int
        :rtype: void
        """
        return self.towers_of_hanoi_helper(n, POSITION.SRC, POSITION.DEST, POSITION.AUX)
    
    def towers_of_hanoi_helper(self, n, src, dest, aux):
        """
        :type num_discs: int
        :type n: Move
        :type src: Move
        :type dest: Move
        :type aux: Move
        :rtype: List[Move]
        """
        # base case
        if n == 1:
            return str(Move(n, src, dest))
        
        result = []
        result.append(self.towers_of_hanoi_helper(n-1, src, aux, dest))
        result.append(str(Move(n, src, dest)))
        result.append(self.towers_of_hanoi_helper(n-1, aux, dest, src))
        return result
