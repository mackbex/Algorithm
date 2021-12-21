def gen_permutation():
    if len(P) == n:
        print(P)
    else:
        for i in range(1, n+1):
            if chosen[i] == True:
                continue
            chosen[i] = True
            P.append(i)
            gen_permutation()
            chosen[i] = False
            P.pop()
P = []
n = int(input())
chosen = [False for _ in range(n+1)]
gen_permutation()