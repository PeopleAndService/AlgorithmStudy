import sys


def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())
graph = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
city = list(map(int, sys.stdin.readline().rstrip().split()))
parent = [0] * (n+1)

for i in range(1, n+1):
    parent[i] = i

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            union(parent, i+1, j+1)

cur_city = city[0]
result = True
for i in range(1, n+1):
    if find(parent, cur_city) == find(parent, i):
        cur_city = i
    else:
        result = False
        break

if result:
    print('YES')
else:
    print('NO')
