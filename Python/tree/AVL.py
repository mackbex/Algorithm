import tree.BinarySearchTree as BST
BST = BST.Tree()


class AVL(BST):

    def insert(self, key):
        v = super(AVL, self).insert(key)

