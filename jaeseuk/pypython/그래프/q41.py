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
parents = [0] * (n + 1)

for i in range(1, n + 1):
    parents[i] = i

for i in range(1, n + 1):
    graph = list(map(int, stdin.readline().rstrip().split()))
    for j in range(n):
        if graph[j] == 1:
            union(parents, i, j + 1)

plan = list(map(int, stdin.readline().rstrip().split()))

result = True
for i in range(m - 1):
    if find(parents, plan[i]) != find(parents, plan[i + 1]):
        result = False
        break

if result:
    print("YES")
else:
    print("NO")