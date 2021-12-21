def binary(ar, target, begin, end):
    if begin > end:
        return -1
    else:
        middle = (begin + end) // 2
        if target == ar[middle]:
            compRes = 0
        elif target >= ar[middle]:
            compRes = 1
        else:
            compRes = -1
        if compRes == 0:
            return middle
        elif compRes < 0:
            return binary(ar,target, begin, middle-1)
        else:
            return binary(ar,target, middle+1, end)


print(binary([1,2,3,4,5,6,7],6,0,6))