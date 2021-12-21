
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





