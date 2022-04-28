import time

n = int(input("number of elements : "))
haystack = [k for k in range(n)]

ts = time.time()
maximum = max(haystack)
elapsed = time.time() - ts

print("max = %d, Elapsed time = %.2f" % (maximum, elapsed))