class Heap:
    def __init__(self, L=[]):
        self.A = L


    def make_heap(self, A):
        n = len(A)
        for k in range(n-1, -1, -1):
           self.heapify_down(k, n)

    def heapify_down(self, k, n):
        while 2 * k+1 < n :
            L = 2*k+1
            R = 2*k+2
            if self.A[L] > self.A[k]:
                m = L
            else:
                m = k
            if R < n and self.A[R] > self.A[m]:
                m = R

            if m != k:
                self.A[k], self.A[m] = self.A[m], self.A[k]
                k = m
            else:
                break

    def heapify_up(self, k):
        while k > 0 and self.A[(k-1) // 2] < self.A[k]:
            self.A[(k-1) // 2], self.A[k] = self.A[k], self.A[(k-1) // 2]
            k = (k-1)//2

    def insert(self, v):
        self.A.append(v)
        self.heapify_up(len(self.A)-1)

    def find_max(self):
        return self.A[0]

    def delete_max(self):
        if len(self.A) == 0: return None
        key = self.A[0]
        self.A[0] = self.A[len(self.A) - 1]
        self.A.pop()
        self.heapify_down(0, len(self.A))
        return key