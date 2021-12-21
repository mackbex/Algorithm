# def func(n):
#     if n > 0:
#         return n + func(n-1)
#     else:
#         return 0
#
#
#
# print(func(4))


def sum(n):
    if n == 1: return 1
    return sum(n-1) + n

def sum(n, m):
    if n == m:
        return n
    if n > m : return 0
    a = (n + m) // 2
    return sum(n, a) + sum (a+1, m)

def reverse(s):
    if len(s) == 1: return s
    return reverse(s[1:]) + s[:1]

def reverse2(s, start, stop):
    if start < stop - 1:
        s[start], s[stop-1] = s[stop-1], s[start]
        reverse2(s, start+1, stop-1)

print(reverse2([1,2,3,4,5],0,5))

