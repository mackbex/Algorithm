class Heap:
    def __init__(self, L=[]):
        self.A = L
    def __str__(self):
        return str(self.A)

    def heapify_down(self, k, n):

        while 2 * k + 1 < n:
            L = 2 * k + 1
            R = 2 * k + 2

            if self.A[L] > self.A[k]:
                m = L
            else:
                m = k

            if R < n and self.A[R] > self.A[m]:
                m = R

            if m != k:
                self.A[m], self.A[k] = self.A[k], self.A[m]
                k = m
            else:
                break

    def make_heap(self):
        n = len(self.A)
        for i in range(n-1, -1, -1):
            self.heapify_down(i,n)

    def heap_sort(self):
        n = len(self.A)
        for k in range(len(self.A)-1, -1, -1):
            self.A[0], self.A[k] = self.A[k], self.A[0]
      #      n = n - 1
            self.heapify_down(0, n)


S = [int(x) for x in input().split()]
H = Heap(S)
H.make_heap()
H.heap_sort()
print(H)