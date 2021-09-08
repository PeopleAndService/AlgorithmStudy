"""
구현(시뮬레이션)
백준 16235 나무 재테크 골드4
제한 : 1.3초 / 512MB
제출 : 608ms / 146008KB
"""

import sys

N, M, K = map(int, sys.stdin.readline().rstrip().split())
A = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
ground = [[5] * N for _ in range(N)]
tree_age = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(M):
    r, c, age = map(int, sys.stdin.readline().rstrip().split())
    tree_age[r-1][c-1].append(age)

dir = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

for _ in range(K):
    # 봄, 여름
    for i in range(N):
        for j in range(N):
            if tree_age[i][j]:
                tree_age[i][j].sort()
                new_tree_age = []
                dead_trees = 0
                for age in tree_age[i][j]:
                    if age > ground[i][j]:
                        dead_trees += age // 2
                    else:
                        ground[i][j] -= age
                        age += 1
                        new_tree_age.append(age)
                tree_age[i][j] = new_tree_age
                ground[i][j] += dead_trees

    if not tree_age:
        print(0)
        sys.exit()

    # 가을
    for i in range(N):
        for j in range(N):
            if tree_age[i][j]:
                for age in tree_age[i][j]:
                    if age % 5 == 0:
                        for x, y in dir:
                            next_r = i + x
                            next_c = j + y
                            if (0 <= next_r < N) and (0 <= next_c < N):
                                tree_age[next_r][next_c].append(1)
            # 겨울
            ground[i][j] += A[i][j]

t_cnt = 0
for i in range(N):
    for j in range(N):
        if tree_age[i][j]:
            t_cnt += len(tree_age[i][j])

print(t_cnt)
