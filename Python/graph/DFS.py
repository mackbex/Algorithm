import sys

sys.setrecursionlimit(5000)


stack = []

def DFS(s):
    stack.push((p, s))
    while len(stack) > 0:
        p.v = stack.pop()
        if v.mark is not False:
            v.mark = True
            parent.append(p)
            for w in G[v]:
                if not visited[v]:
                    stack.push(v, w)


#
# def DFS(G, v):
#     global curr_time  # pre, post를 위한 time stamp
#     # 그래프 G의 노드 v를 DFS 방문한다
#     parent.append(v)
#     visited[v] = True
#     pre[v] = curr_time
#     curr_time += 1
#     for w in G[v]:
#         if not visited[w]:
#             DFS(G, w)
#     post[v] = curr_time
#     curr_time += 1


def DFSAll(G):
    # 그래프 G를 DFS 방문한다
    for v in range(n):
        if visited[v] == False:
            DFS(G, v)

# 입력 처리
n, m = [int(x) for x in input().split()]
G = [[] for _ in range(n)]
# G 입력 받아 처리

for _ in range(0, m):
    v, w = input().split()
    G[int(v)].append(int(w))


# visited, pre, post 리스트 정의와 초기화
visited = [False] * n
pre = [0] * n
parent = []
post = [0] * n
# curr_time = 1로 초기화
curr_time = 1

DFSAll(G)

# 출력
for i in parent:
    print(i, end=' ')
    print()
for i in range(0, len(pre)):
    print('[', pre[i], ', ', post[i], ']', end=' ')
