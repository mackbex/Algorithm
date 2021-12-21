def search(ar, begin, end, target):
    if begin > end:
        return -1
    else:
        middle = begin + end // 2
        if ar[middle] == target:
            return middle

        index = search(ar, begin, middle -1, target)
        if index != -1:
            return index

        return search(ar, middle+1, end, target)



print(search([1, 2, 3, 4], 0, 3, 4))
