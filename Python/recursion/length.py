def length(str):
    if not str:
        return 0
    else:
        return 1+length(str[1:])

print(length("abcde"))
