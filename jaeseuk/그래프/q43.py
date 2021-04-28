from sys import stdin


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


n, m = map(int, stdin.readline().rstrip().split())
parent = [0] * n
edges = []

for i in range(n):
    parent[i] = i

for _ in range(m):
    x, y, z = map(int, stdin.readline().rstrip().split())
    edges.append((z, x, y))

edges.sort()

result = 0
for edge in edges:
    cost, a, b = edge

    if find(parent, a) == find(parent, b):
        result += cost
    else:
        union(parent, a, b)

print(result)
