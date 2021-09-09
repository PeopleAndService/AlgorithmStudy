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


g = int(stdin.readline().rstrip())
p = int(stdin.readline().rstrip())
parents = [0] * (g + 1)
data = []

for i in range(1, g + 1):
    parents[i] = i

for _ in range(p):
    data.append(int(stdin.readline().rstrip()))

result = 0
for i in range(p):
    gi = data[i]
    root = find(parents, gi)

    if root == 0:
        break

    union(parents, root, root - 1)
    result += 1

print(result)
