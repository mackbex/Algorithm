N = 8
cols = [0 for i in range(N + 1)]


def queens(lv):
    if not promising(lv):
        return False
    elif lv == N:
        for i in range(0, N + 1):
            print("(", i, ", ", cols[i], ")")
        return True
    for i in range(0, N + 1):
        cols[lv + 1] = i
        if queens(lv + 1):
            return True

    return False


def promising(lv):
    for i in range(0, lv):
        if cols[i] == cols[lv]:
            return False
        elif lv - i == abs(cols[lv] - cols[i]):
            return False
    return True


queens(0)
