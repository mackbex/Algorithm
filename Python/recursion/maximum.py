def maximum(ar, begin, end):
    if begin == end:
        return ar[begin]
    else:
        return max(ar[begin],maximum(ar,begin+1,end))

print(maximum([1,2,3],0,2))