# 시간 초과
import heapq
import sys

n, m, k = map(int, sys.stdin.readline().rstrip().split())
land = [[5] * n for _ in range(n)]
a = []
trees = {}

for _ in range(n):
    a.append(list(map(int, sys.stdin.readline().rstrip().split())))

for _ in range(m):
    x, y, z = map(int, sys.stdin.readline().rstrip().split())
    key = (x, y)
    h = []
    heapq.heappush(h, z)
    trees[key] = h

for _ in range(k):
    dead = []
    # 봄
    for key in trees.keys():
        for i in range(len(trees[key])):
            x, y = key[0] - 1, key[1] - 1
            tree = trees[key][i]
            if land[x][y] >= tree:
                land[x][y] -= tree
                trees[key][i] += 1
            else:
                dead.append([key, tree])
    # 여름
    for d in dead:
        x, y, z = d[0][0] - 1, d[0][1] - 1, d[1]
        land[x][y] += z // 2
        key = (x + 1, y + 1)
        trees[key].remove(z)
    # 가을
    near = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
    nkey = []
    for key in trees.keys():
        x, y = key[0], key[1]
        for i in range(len(trees[key])):
            if trees[key][i] % 5 == 0:
                for j in near:
                    nx = x + j[0]
                    ny = y + j[1]
                    if 1 <= nx <= n and 1 <= ny <= n:
                        k = (nx, ny)
                        nkey.append(k)

    for nk in nkey:
        if nk in trees:
            heapq.heappush(trees[nk], 1)
        else:
            h = []
            heapq.heappush(h, 1)
            trees[nk] = h
    # 겨울
    for i in range(len(a)):
        for j in range(len(a)):
            land[i][j] += a[i][j]

count = 0
for tree in trees.values():
    count += len(tree)

print(count)
