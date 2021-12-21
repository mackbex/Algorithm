N = 8
maze = [
    [0, 0, 0, 0, 0, 0, 0, 1],
    [0, 1, 1, 0, 1, 1, 0, 1],
    [0, 0, 0, 1, 0, 0, 0, 1],
    [0, 1, 0, 0, 1, 1, 0, 0],
    [0, 1, 1, 1, 0, 0, 1, 1],
    [0, 1, 0, 0, 0, 1, 0, 1],
    [0, 0, 0, 1, 0, 0, 0, 1],
    [0, 1, 1, 1, 0, 1, 0, 0]
]
PATHWAY = 0
WALL = 1
BLOCKED = 2
PATH = 3


def find(x, y):
    if x < 0 or y < 0 or x >= N or y >= N:
        return False
    elif maze[x][y] != PATHWAY:
        return False
    elif x == N - 1 and y == N - 1:
        maze[x][y] = PATH
        return True
    else:
        maze[x][y] = PATH
        if find(x - 1, y) or find(x, y + 1) or find(x + 1, y) or find(x, y - 1):
            return True
        maze[x][y] = BLOCKED
        return False


def printMaze(ar):
    print("\n")
    for i in ar:
        print(i)
    print("\n")

printMaze(maze)
find(0,0)
printMaze(maze)