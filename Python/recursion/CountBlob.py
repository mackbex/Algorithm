blob = [
    [1, 0, 0, 0, 0, 0, 0, 1],
    [0, 1, 1, 0, 0, 1, 0, 0],
    [1, 1, 0, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 1, 0, 0],
    [0, 1, 0, 1, 0, 1, 0, 0],
    [0, 1, 0, 1, 0, 1, 0, 0],
    [1, 0, 0, 0, 1, 0, 0, 1],
    [0, 1, 1, 0, 0, 1, 1, 1]
]

COUNTED=3
N=8

def countCell(x, y):
    if x < 0 or y < 0 or x >= N or y >= N:
        return 0
    if blob[x][y] == 0 or blob[x][y] == COUNTED:
        return 0
    else:
        blob[x][y] = 3
        return 1 + countCell(x-1,y-1) + countCell(x-1,y) + countCell(x,y-1) + countCell(x+1,y) + countCell(x+1,y+1) + countCell(x,y+1) + countCell(x-1,y+1) + countCell(x+1,y-1)

def printBlob(ar):
    print("\n")
    for i in ar:
        print(i)
    print("\n")


print(countCell(0, 0))