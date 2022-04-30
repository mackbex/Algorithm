def solution(L, x):
    idx = -1
    under = 0
    upper = len(L) -1
    while under <= upper :
        middle = (under + upper) // 2
        if L[middle] == x :
            return middle
        elif L[middle] < x :
            under = middle + 1
        else :
            upper = middle - 1
    return -1