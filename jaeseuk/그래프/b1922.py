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


n = int(stdin.readline().rstrip())
m = int(stdin.readline().rstrip())
parent = [0] * (n + 1)

for i in range(1, n + 1):
    parent[i] = i

edges = []
for _ in range(m):
    a, b, c = map(int, stdin.readline().rstrip().split())

    if a != b:
        edges.append((c, a, b))

edges.sort()

result = 0
for edge in edges:
    c, a, b = edge

    if find(parent, a) != find(parent, b):
        result += c
        union(parent, a, b)

print(result)
