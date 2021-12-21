class Node:
    def __init__(self, key):
        self.key = key
        self.parent = self.left = self.right = None
        self.height = 1

    def __str__(self):
        return str(self.key)


class Tree:
    def __init__(self):
        self.root = None
        self.size = 0

    def __len__(self):
        return self.size

    def preorder(self, v):
        if v is None: return None
        print(v.key)
        self.preorder(v.left)
        self.preorder(v.right)

    def inorder(self, v):
        if v is None: return None
        self.preorder(v.left)
        print(v.key)
        self.preorder(v.right)

    def postorder(self, v):
        if v is None: return None
        self.preorder(v.left)
        self.preorder(v.right)
        print(v.key)


    def find_loc(self, key):
        if self.size == 0: return None
        p = None
        v = self.root
        while v is not None:
            if v.key == key:
                return v
            if v.key > key:
                p = v
                v = v.left
            else:
                p = v
                v = v.right
        return p

    def search(self, key):
        return self.find_loc(key)

    def insert(self, key):
        p = self.find_loc(key)
        if p is None or p is not key:
            v = Node(key)

            if p is None:
                self.root = v
            else:
                v.parent = p
                if p.key > key:
                    p.left = v
                else:
                    p.right = v
                p.height = 1 + max(self.height(p.left), self.height(p.right))
            self.size += 1
            return v
        else:
            return p

    def height(self, n):
        if n is None:
            return 0
        return n.height

    def deleteByMerging(self, x):
        a = x.left, b = x.right
        p = x.parent

        if a is None:
            c = b
        else:
            c = a
            m = a
            while m.right:
                m = m.right
            if b is not None:
                b.parent = m

        if p is None:
            self.root = c
            if c:
                c.parent = None
        else:
            if c:
                c.parent = p
                if p.key < c.key:
                    p.right = c
                else:
                    p.left = c
        self.size -= 1

    def rotateRight(self, z):
        if not z: return
        x = z.left
        if not x: return
        b = x.right
        x.parent = z.parent
        if z.parent:
            if z.parent.left == z :
                z.parent.left = x
            else:
                z.parent.right = x
        x.right = z
        z.parent = x
        z.left = b
        if b:
            b.parent = z

        if self.root == z:
            self.root = x

        x.height = max(self.height(x.left), self.height(x.right)) + 1
        z.height = max(self.height(z.left), self.height(z.right)) + 1


    def rotateLeft(self, x):
            if not x: return
            z = x.right
            if not z: return
            b = z.left
            z.parent = x.parent
            if x.parent:
                if x.parent.left == x:
                    x.parent.left = z
                else:
                    x.parent.right = z

            z.left = x
            x.right = b
            x.parent = z

            if b:
                b.parent = x

            if self.root == x:
                self.root = z

            x.height = max(self.height(x.left), self.height(x.right)) + 1
            z.height = max(self.height(z.left), self.height(z.right)) + 1












T = Tree()

while True:
    cmd = input().split()
    if cmd[0] == 'insert':
        v = T.insert(int(cmd[1]))
        if v != None:
            print("+ {0} is set into H".format(v.key))
        else:
            print(v.key, "is already in the tree!")
    elif cmd[0] == 'search':
        v = T.search(int(cmd[1]))
        if v == None: print("* {0} is not found!".format(cmd[1]))
        else: print(" * {0} is found!".format(cmd[1]))
    elif cmd[0] == 'preorder':
        T.preorder(T.root)
        print()
    elif cmd[0] == 'rotateleft':
        T.rotateLeft(T.root)
        print()
    elif cmd[0] == 'rotateright':
        T.rotateRight(T.root)
        print()
    elif cmd[0] == 'postorder':
        T.postorder(T.root)
        print()
    elif cmd[0] == 'inorder':
        T.inorder(T.root)
        print()
    elif cmd[0] == 'exit':
        break
    else:
        print("* not allowed command. enter a proper command!")
