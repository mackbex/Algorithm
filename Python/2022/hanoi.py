
MSG_FORMAT = "{} disk from {} to {}"
def move(N, start, to):
    print(MSG_FORMAT.format(N, start, to))

def solution(N, start, to, via):
    if N == 1:
        move(1, start, to)
    else :
        solution(N-1, start, via, to)
        move(N, start, to)
        solution(N-1, via, to, start)

print(solution(3, 'A', 'C', 'B'))