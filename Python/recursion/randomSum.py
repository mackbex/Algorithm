import time, random


num = int(input())
A = [random.randint(0, 100) for _ in range(num)]
B = [[0] * num for _ in range(num)]

def sum(A, n):
    for i in range(n):
        for j in range(i, n):
            B[i][j] = B[i][j-1] + A[j]

before = time.process_time()
sum(A, num)
after = time.process_time()
print(B)
print(after-before)
print(A[-1])