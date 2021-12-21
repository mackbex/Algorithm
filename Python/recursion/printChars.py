def printChar(str):
    if not str:
        return
    else:
        printChar(str[1:])
        print(str[0])


print(printChar("abc"))