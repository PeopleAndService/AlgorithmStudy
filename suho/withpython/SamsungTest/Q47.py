import copy
import sys

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, -1, -1, -1, 0, 1, 1, 1]

# 입력
input_list = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(4)]
arr = [[None] * 4 for _ in range(4)]
for i in range(4):
    for j in range(4):
        arr[i][j] = [input_list[i][j*2], input_list[i][j*2+1] - 1]


# 물고기 찾기
def find_fish_coord(arr, num):
    for i in range(4):
        for j in range(4):
            if arr[i][j][0] == num:
                return i, j
    return -1, -1


# 물고기 이동
def move_fish(arr, shark):
    # 1 ~ 16번
    for i in range(1, 17):
        fish_r, fish_c = find_fish_coord(arr, i)
        if fish_r == -1:
            continue
        fish_dir = arr[fish_r][fish_c][1]
        # 회전
        for _ in range(8):
            next_r = fish_r + dr[fish_dir]
            next_c = fish_c + dc[fish_dir]
            if 0 <= next_r < 4 and 0 <= next_c < 4:
                if not (next_r == shark[0] and next_c == shark[1]):
                    arr[fish_r][fish_c][1] = fish_dir
                    arr[fish_r][fish_c], arr[next_r][next_c] = arr[next_r][next_c], arr[fish_r][fish_c]
                    break
            fish_dir += 1
            if fish_dir >= 8:
                fish_dir = 0


# 상어가 먹을 수 있는 것
def move_shark(arr, shark):
    eat = []
    shark_dir = arr[shark[0]][shark[1]][1]
    for _ in range(4):
        shark[0] += dr[shark_dir]
        shark[1] += dc[shark_dir]
        if 0 <= shark[0] < 4 and 0 <= shark[1] < 4:
            if arr[shark[0]][shark[1]][0] != -1:
                eat.append([shark[0], shark[1]])
    return eat


# 상태 공간 트리 탐색
def dfs(arr, shark, count):
    global result
    temp = copy.deepcopy(arr)

    count += temp[shark[0]][shark[1]][0]
    temp[shark[0]][shark[1]][0] = -1

    move_fish(temp, shark)
    eatable = move_shark(temp, shark)

    if not eatable:
        result = max(result, count)
        return

    for next_shark in eatable:
        dfs(temp, next_shark, count)


result = 0
dfs(arr, [0, 0], 0)
print(result)
