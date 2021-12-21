class Node:
    def __init__(self, key):
        self.key = key
        self.parent = self
        self.rank = 0

    def make_set(self, x):
        return Node(x)

    def find(self, x):
        while x.parent != x:
            x = x.parent
        return x

    def union(self,x,y):
        v, w = self.find(x), self.find(y)

        if v.parent == w.parent: return

        if v.rank > w.rank:
            w.parent = v
        elif v.rank < w.rank:
            v.parent = w
        else:
            v.parent = w
            w.rank += 1


