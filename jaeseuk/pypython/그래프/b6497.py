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


while True:
    m, n = map(int, stdin.readline().rstrip().split())

    if m == 0 and n == 0:
        break

    parent = [0] * m

    for i in range(m):
        parent[i] = i

    edges = []
    for _ in range(n):
        x, y, z = map(int, stdin.readline().rstrip().split())
        edges.append((z, x, y))

    edges.sort()

    result = 0
    for edge in edges:
        z, x, y = edge

        if find(parent, x) != find(parent, y):
            union(parent, x, y)
        else:
            result += z

    print(result)
