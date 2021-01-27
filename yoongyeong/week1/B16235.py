# 나무 재테크
# 입력: 1) 땅 크기 N, 나무 갯수 M, 지난 햇수 K 2~) 겨울에 양분을 추가해주는 배열 A 3~) 나무 위치(x, y), 나이 z
# 출력: K년이 지난 후 살아남은 나무의 수

import sys
from collections import deque

N, M, K = map(int, input().split())
nutrient_map = [[5] * N for _ in range(N)]  # 양분
Trees = deque()  # x, y, 나이
Tree_index = set()
A = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
for i in range(M):
    x, y, age = list(map(int, sys.stdin.readline().rstrip().split()))
    Trees.append([x - 1, y - 1, age])
    Tree_index.add((x - 1, y - 1))

steps = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

for year in range(K):
    DieTrees = []  # x, y, 나이
    AppendTrees = []  # x, y
    # spring: 나무가 나이만큼 양분 먹고, 나이 1 증가, 나이 어린 나무부터 먹음, 양분 못먹으면 죽음
    for i in range(len(Trees)):
        x, y, age = Trees.popleft()
        if (A[x][y] * year) + nutrient_map[x][y] < age:
            DieTrees.append([x, y, age])
        else:
            nutrient_map[x][y] -= age
            Trees.append([x, y, age + 1])
            if (age + 1) % 5 == 0:  # autumn: 나무의 번식, 번식하는 나무는 나이가 5의 배수, 인접한 8개의 칸에는 나이가 1인 나무 생성
                for x_step, y_step in steps:
                    if 0 <= (x + x_step) < N and 0 <= (y + y_step) < N:
                        AppendTrees.append([x + x_step, y + y_step])

    # summer: 죽은 나무가 양분으로 변함 (죽은 나무의 나이 / 2)
    for x, y, age in DieTrees:
        nutrient_map[x][y] += age // 2
    for x, y in AppendTrees:
        Trees.appendleft([x, y, 1])

print(len(Trees))