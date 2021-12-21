def gcd1(a, b):
    while a != 0 and b != 0:
        if a > b : a = a - b
        else : b = b - a
    return a + b

def gcd2(a, b):
    while a != 0 and b != 0:
        if a > b : a = a % b
        else : b = b % a
    return a + b

def gcd3(a, b):
    if a > b:
        tmp = a
        a = b
        b = tmp

    if a == 0:
        return b

    return gcd3(a, b%a)

print(gcd3(366, 60))