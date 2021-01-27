import sys

n, m, x, y, k = map(int, sys.stdin.readline().rstrip().split())

maps = []
for _ in range(n):
    maps.append(list(map(int, sys.stdin.readline().rstrip().split())))

order = list(map(int, sys.stdin.readline().rstrip().split()))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

dice = [[0] * 3 for _ in range(4)]


def roll(r_dice, r_direction):
    fx = 1 + dx[r_direction - 1]
    fy = 1 + dy[r_direction - 1]
    if r_direction == 1 or r_direction == 2:
        temp = r_dice[fx][fy]
        r_dice[fx][fy] = r_dice[3][1]
        r_dice[3][1] = temp

        shift = r_dice[fx].pop(fy)
        if r_direction == 1:
            r_dice[fx].insert(0, shift)
        else:
            r_dice[fx].insert(2, shift)
    else:
        shift_list = [r_dice[i][1] for i in range(len(r_dice))]

        if r_direction == 3:
            shift = shift_list.pop(0)
            shift_list.insert(3, shift)
        else:
            shift = shift_list.pop(3)
            shift_list.insert(0, shift)

        for i in range(len(shift_list)):
            dice[i][1] = shift_list[i]


for direction in order:
    nx = x + dx[direction - 1]
    ny = y + dy[direction - 1]

    if 0 <= nx <= n - 1 and 0 <= ny <= m - 1:
        roll(dice, direction)
        if maps[nx][ny] == 0:
            maps[nx][ny] = dice[3][1]
        else:
            dice[3][1] = maps[nx][ny]
            maps[nx][ny] = 0
        x, y = nx, ny
        print(dice[1][1])
