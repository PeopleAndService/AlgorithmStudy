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


g = int(input())
p = int(input())
parent = [0] * (g + 1)
count = 0

for i in range(1, g+1):
    parent[i] = i

for _ in range(p):
    plane = int(input())
    gate = find(parent, plane)
    if gate == 0:
        break
    union(parent, gate, gate-1)
    count += 1

print(count)
