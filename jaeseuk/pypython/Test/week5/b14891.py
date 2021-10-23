from sys import stdin
from collections import deque


def rotate_gear(start, num, di):
    if num == 1:
        if start != num + 1 and gears[num - 1][2] != gears[num][6]:
            rotate_gear(num, num + 1, -di)
        gears[num - 1].rotate(di)
    elif num == 2:
        if start != num + 1 and gears[num - 1][2] != gears[num][6]:
            rotate_gear(num, num + 1, -di)

        if start != num - 1 and gears[num - 1][6] != gears[num - 2][2]:
            rotate_gear(num, num - 1, -di)

        gears[num - 1].rotate(di)
    elif num == 3:
        if start != num + 1 and gears[num - 1][2] != gears[num][6]:
            rotate_gear(num, num + 1, -di)

        if start != num - 1 and gears[num - 1][6] != gears[num - 2][2]:
            rotate_gear(num, num - 1, -di)

        gears[num - 1].rotate(di)
    else:
        if start != num - 1 and gears[num - 1][6] != gears[num - 2][2]:
            rotate_gear(num, num - 1, -di)
        gears[num - 1].rotate(di)


gears = [deque(stdin.readline().rstrip()) for _ in range(4)]
k = int(stdin.readline().rstrip())
rotates = [tuple(map(int, stdin.readline().rstrip().split())) for _ in range(k)]
score = [1, 2, 4, 8]

for rotate in rotates:
    n, d = rotate
    rotate_gear(n, n, d)

answer = 0
for i in range(4):
    if gears[i][0] == '1':
        answer += score[i]

print(answer)
