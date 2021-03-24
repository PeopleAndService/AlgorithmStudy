import sys
from itertools import combinations

sys.setrecursionlimit(10000)

n = int(input())
school = [list(sys.stdin.readline().rstrip().split()) for _ in range(n)]

teacher = []
no_obst = []

result = False

for i in range(n):
    for j in range(n):
        if school[i][j] == "T":
            teacher.append((i, j))
        elif school[i][j] == "X":
            no_obst.append((i, j))

dir = ['u', 'd', 'l', 'r']


def search(x, y, direction):
    if direction == 'u':
        while x >= 0:
            if school[x][y] == "S":
                return True
            if school[x][y] == "O":
                return False
            x -= 1
    if direction == 'd':
        while x < n:
            if school[x][y] == "S":
                return True
            if school[x][y] == "O":
                return False
            x += 1
    if direction == 'l':
        while y >= 0:
            if school[x][y] == "S":
                return True
            if school[x][y] == "O":
                return False
            y -= 1
    if direction == 'r':
        while y < n:
            if school[x][y] == "S":
                return True
            if school[x][y] == "O":
                return False
            y += 1

    return False


def check_teacher():
    for x, y in teacher:
        for i in range(4):
            if search(x, y, dir[i]):
                return True
    return False


for case in combinations(no_obst, 3):
    for x, y in case:
        school[x][y] = "O"
    if not check_teacher():
        result = True
        break
    for x, y in case:
        school[x][y] = "X"

if result:
    print("YES")
else:
    print("NO")
