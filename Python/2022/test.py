from audioop import reverse


n = int(input())
m = input()

unit = 1
for x in reversed(m):
    print(n*int(x))

print(n*int(m))