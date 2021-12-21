class Node:
    def __init__(self, key=None):
        self.key = key
        self.next = self
        self.previous = self


class DoublyLinkedList:
    def __init__(self):
        self.head = Node()
        self.size = 0

    def __iter__(self):
        node = self.head
        while node is not None:
            yield node
            node = node.next

    def __len__(self):
        return self.size

    def splice(self, a, b, x):
        ap = a.prev, bn = b.next, xn = x.next
        ap.next = bn
        bn.prev = ap
        xn.next = a
        a.prev = x
        b.next = xn
        xn.prev = b

    def moveAfter(self, a, x):
        self.splice(a, a, x)

    def moveBefore(self, a, x):
        self.splice(a, a, x.prev)

    def insertAfter(self, x, key):
        self.moveAfter(Node(key), x)

    def insertBefore(self, x, key):
        self.moveBefore(Node(key), x)

    def pushAfter(self, key):
        self.insertAfter(Node(key), self.head)

    def pushBefore(self, key):
        self.insertBefore(Node(key), self.head)

    def search(self, key):
        v = self.head
        while v.next is not None:
            if v.next == key:
                return v
            v = v.next
        return None

    def remove(self, x):
        if x is None or x is self.head:
            return None
        x.prev.next = x.next
        x.next.prev = x.prev
        del x

    def popFront(self):
        if self.head.next is None:
            self.remove(self.head.next)

    def popBack(self):
        if self.head.prev is None:
            self.remove(self.head.prev)