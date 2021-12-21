def sum(n, ar):
    if n <= 0:
        return 0
    else:
        return sum(n-1, ar) + ar[n-1]


ar = [1,2,3]
print(sum(3, ar))
